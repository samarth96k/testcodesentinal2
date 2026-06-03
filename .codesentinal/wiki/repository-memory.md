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
