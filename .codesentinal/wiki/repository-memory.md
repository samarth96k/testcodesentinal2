# Repository Memory

This file stores long-term repository knowledge.

## Architectural Decisions

Document major architectural decisions.

---


### Memory ID: f59db29b8789

Created At: 2026-06-03T11:20:30.873Z

**Reason**

Standardizing external communication patterns.

**Knowledge**

External service interactions (GitHub API, Wiki updates) must be routed through `GitHubRetryService` to ensure consistent exponential backoff and retry logic. Do not implement manual retry loops in feature code.

---

## Known Constraints

Document repository limitations.

---

## Migration Notes

Document migrations and compatibility concerns.

---

## Review Findings

Document recurring review findings and lessons.

---

## Integration Knowledge

Document external integrations, workflows, and cross-system behavior.


### Memory ID: 88a548f42ce6

Created At: 2026-10-03T08:06:29.744Z

**Reason**

Standardizing cross-service retry patterns is critical for system reliability.

**Knowledge**

GitHub interactions now rely on GitHubRetryService for exponential backoff retries. Standard retry configuration is 4 attempts with a base delay of 1s (doubling per attempt). New integrations with external APIs should utilize this pattern to ensure consistent failure handling.

---
