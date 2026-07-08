# UI Guidelines

## Product Feel

The app should feel focused, calm, and professional. It is a learning tool first. Visual polish should support reading comfort, not distract from it.

## Reading Screen

The reading screen is the most important surface in Phase 1.

Required elements:

- Lesson title.
- Current sentence.
- Word-by-word highlight.
- Pause and resume control.
- Speed control.
- Timer.
- Progress indicator.
- Exit or finish action.

Rules:

- The current sentence must be visually dominant.
- Highlighting must remain readable in light and dark themes.
- Controls must be reachable on mobile.
- Timer and progress must be visible without competing with the sentence.
- Pausing must freeze highlighting and timer behavior consistently.
- Restart must reset the lesson intentionally after confirmation when progress would be lost.

## Word Highlighting

- Highlight only the active word unless a future mode explicitly supports phrase highlighting.
- Use color, weight, or background in a way that remains accessible.
- Avoid animated effects that make reading harder.
- The highlight transition should feel smooth but not lag behind timing.
- Punctuation should stay attached to the word it belongs to.

## Responsive Layout

Mobile:

- Single-column layout.
- Bottom controls for primary reading actions.
- Large touch targets.
- Avoid dense dashboards.

Tablet:

- Center reading content with supplementary progress controls nearby.
- Use side panels only when they do not crowd the sentence.

Desktop Web:

- Center the reading experience.
- Use wider space for lesson browsing and statistics.
- Keep maximum line length comfortable for reading.

## Navigation

Primary destinations:

- Home
- Lessons
- Categories
- Statistics
- Profile

Reading sessions should feel immersive. Navigation chrome may be reduced while reading, but the user must always have a clear way to exit.

## Empty States

Empty states should explain what is missing and provide the next action.

Examples:

- No lessons in category: show category title and link back to all lessons.
- No progress: invite user to start the first beginner lesson.
- No statistics: show a simple empty chart state and a start reading action.

## Error States

Errors should be concise and actionable:

- Network unavailable: allow retry.
- Session save failed: keep local state and retry when possible.
- Lesson unavailable: return to lessons list.
- Authentication expired: prompt sign-in without losing intended destination.

## Accessibility

- Support text scaling.
- Maintain color contrast of at least WCAG AA.
- Provide semantic labels for controls.
- Ensure keyboard navigation works on Web.
- Do not rely on color alone to communicate progress or active state.

