create table reading_session_sentence_events (
  id uuid primary key,
  reading_session_id uuid not null references reading_sessions(id) on delete cascade,
  sentence_id uuid not null references sentences(id),
  sentence_position int not null,
  elapsed_seconds int not null default 0,
  words_read int not null default 0,
  started_at timestamptz not null,
  completed_at timestamptz,
  created_at timestamptz not null,
  constraint reading_session_sentence_events_session_position_unique unique (reading_session_id, sentence_position),
  constraint reading_session_sentence_events_sentence_position_check check (sentence_position > 0),
  constraint reading_session_sentence_events_elapsed_seconds_check check (elapsed_seconds >= 0),
  constraint reading_session_sentence_events_words_read_check check (words_read >= 0)
);

create index reading_session_sentence_events_session_idx on reading_session_sentence_events (reading_session_id);
create index reading_session_sentence_events_sentence_idx on reading_session_sentence_events (sentence_id);
create index reading_session_sentence_events_session_completed_idx on reading_session_sentence_events (
  reading_session_id,
  completed_at
);
