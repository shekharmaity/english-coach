create table users (
  id uuid primary key,
  email text not null,
  password_hash text not null,
  display_name text not null,
  role text not null default 'USER',
  email_verified boolean not null default false,
  preferred_timezone text not null default 'UTC',
  created_at timestamptz not null,
  updated_at timestamptz not null,
  constraint users_role_check check (role in ('USER', 'ADMIN'))
);

create unique index users_email_lower_idx on users (lower(email));
create index users_created_at_idx on users (created_at);

create table refresh_tokens (
  id uuid primary key,
  user_id uuid not null references users(id),
  token_hash text not null unique,
  expires_at timestamptz not null,
  revoked_at timestamptz,
  created_at timestamptz not null
);

create index refresh_tokens_user_id_idx on refresh_tokens (user_id);
create index refresh_tokens_expires_at_idx on refresh_tokens (expires_at);

create table categories (
  id uuid primary key,
  slug text not null unique,
  title text not null,
  description text not null,
  sort_order int not null default 0,
  active boolean not null default true,
  created_at timestamptz not null,
  updated_at timestamptz not null
);

create index categories_active_sort_order_idx on categories (active, sort_order);

create table lessons (
  id uuid primary key,
  category_id uuid not null references categories(id),
  slug text not null unique,
  title text not null,
  description text not null,
  difficulty text not null,
  estimated_seconds int not null,
  default_speed_wpm int not null default 140,
  published boolean not null default false,
  sort_order int not null default 0,
  created_at timestamptz not null,
  updated_at timestamptz not null,
  constraint lessons_difficulty_check check (difficulty in ('BEGINNER', 'INTERMEDIATE', 'ADVANCED')),
  constraint lessons_estimated_seconds_check check (estimated_seconds > 0),
  constraint lessons_default_speed_wpm_check check (default_speed_wpm between 60 and 260)
);

create index lessons_category_published_sort_idx on lessons (category_id, published, sort_order);
create index lessons_difficulty_idx on lessons (difficulty);

create table sentences (
  id uuid primary key,
  lesson_id uuid not null references lessons(id) on delete cascade,
  position int not null,
  content text not null,
  word_count int not null,
  created_at timestamptz not null,
  updated_at timestamptz not null,
  constraint sentences_lesson_position_unique unique (lesson_id, position),
  constraint sentences_position_check check (position > 0),
  constraint sentences_word_count_check check (word_count > 0)
);

create index sentences_lesson_position_idx on sentences (lesson_id, position);

create table user_lesson_progress (
  id uuid primary key,
  user_id uuid not null references users(id),
  lesson_id uuid not null references lessons(id),
  status text not null,
  completion_percent numeric(5, 2) not null default 0,
  last_sentence_position int,
  last_speed_wpm int,
  started_at timestamptz,
  completed_at timestamptz,
  updated_at timestamptz not null,
  constraint user_lesson_progress_unique unique (user_id, lesson_id),
  constraint user_lesson_progress_status_check check (status in ('NOT_STARTED', 'IN_PROGRESS', 'COMPLETED')),
  constraint user_lesson_progress_completion_check check (completion_percent between 0 and 100)
);

create index user_lesson_progress_user_status_idx on user_lesson_progress (user_id, status);
create index user_lesson_progress_lesson_idx on user_lesson_progress (lesson_id);

create table reading_sessions (
  id uuid primary key,
  user_id uuid not null references users(id),
  lesson_id uuid not null references lessons(id),
  status text not null,
  speed_wpm int not null,
  elapsed_seconds int not null default 0,
  words_read int not null default 0,
  started_at timestamptz not null,
  completed_at timestamptz,
  client_platform text not null,
  constraint reading_sessions_status_check check (status in ('ACTIVE', 'PAUSED', 'COMPLETED', 'ABANDONED')),
  constraint reading_sessions_speed_wpm_check check (speed_wpm between 60 and 260),
  constraint reading_sessions_elapsed_seconds_check check (elapsed_seconds >= 0),
  constraint reading_sessions_words_read_check check (words_read >= 0)
);

create index reading_sessions_user_started_idx on reading_sessions (user_id, started_at);
create index reading_sessions_lesson_idx on reading_sessions (lesson_id);
create index reading_sessions_status_idx on reading_sessions (status);

create table daily_streaks (
  id uuid primary key,
  user_id uuid not null references users(id),
  streak_date date not null,
  sessions_completed int not null default 0,
  words_read int not null default 0,
  created_at timestamptz not null,
  updated_at timestamptz not null,
  constraint daily_streaks_user_date_unique unique (user_id, streak_date),
  constraint daily_streaks_sessions_completed_check check (sessions_completed >= 0),
  constraint daily_streaks_words_read_check check (words_read >= 0)
);

create index daily_streaks_user_date_idx on daily_streaks (user_id, streak_date);
