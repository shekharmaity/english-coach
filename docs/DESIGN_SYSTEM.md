# Design System

## Foundation

English Reading Coach uses Material 3 as the base design language. The design system should feel restrained, readable, and supportive of sustained practice.

## Color

Color roles should come from Material 3 theme tokens:

- `primary`: key actions and active reading state.
- `secondary`: supporting actions and category accents.
- `tertiary`: celebratory progress accents used sparingly.
- `surface`: screens and panels.
- `surfaceContainer`: grouped interface regions.
- `error`: destructive or failed states.

Avoid building the product around a single dominant hue. Use neutral surfaces with purposeful accents so the reading text remains central.

## Typography

Recommended roles:

- Display: reserved for onboarding or major dashboard moments.
- Headline: lesson titles and page titles.
- Title: section titles and cards.
- Body: sentence text, descriptions, labels.
- Label: controls, chips, metadata.

Reading sentence text should use a larger body or headline style depending on viewport size. It must not scale directly with viewport width. Use responsive breakpoints and theme text styles.

## Spacing

Use a 4 px base scale:

- `4`: tight internal spacing.
- `8`: compact controls and chips.
- `12`: related element spacing.
- `16`: common component padding.
- `24`: section spacing.
- `32`: major layout spacing.
- `48`: large screen breathing room.

## Shape

- Buttons and cards should follow Material 3 defaults unless a component requires tighter density.
- Repeated lesson cards should use modest radius, not oversized decorative shapes.
- Reading panels should feel stable and unframed when possible.

## Components

Core components:

- Lesson card.
- Category tile.
- Reading sentence view.
- Word highlight span.
- Speed control.
- Timer display.
- Progress bar.
- Streak summary.
- Statistic chart.
- Empty state.
- Error banner.

## Motion

Motion should communicate state, not decorate:

- Highlight transitions should be subtle.
- Route transitions should be quick.
- Progress changes may animate gently.
- Avoid motion that makes text hard to follow.

## Icons

Use icons for common actions such as play, pause, restart, settings, profile, statistics, and lesson navigation. Icons must have accessible labels where needed.

## Dark Theme

Dark theme must be designed, not generated and forgotten. Verify:

- Active word contrast.
- Timer readability.
- Disabled controls.
- Chart colors.
- Error states.

