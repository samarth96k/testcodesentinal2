# Purpose
Provides C/C++ IntelliSense configuration for the Visual Studio Code environment to ensure correct editor behavior during development.

# Responsibilities
- Define compiler path and include directory mappings for the project.
- Establish the C/C++ standard versions used for static analysis and code intelligence.
- Manage workspace-level configuration for indexing and symbol resolution.

# Architectural Role
Development Tooling/Environment Configuration.

# Critical Review Context
Changes to this file modify how the IDE interprets code, which may impact developer productivity, build diagnostics, and navigation accuracy rather than runtime logic.

# Maintenance Notes
- Keep paths synchronized with project build system updates (e.g., changes to include directories or headers).
- Ensure configuration settings align with the target platform's architecture.

# Known Constraints
- This file is environment-specific and primarily intended for local development workflows within Visual Studio Code.
- Modifications do not affect the compiled production binary.

# Related Components
- Project source files requiring header resolution.
- Build system configuration files.

# Repository Memory
- The configuration relies on standard C/C++ language versions to drive IntelliSense.
- It acts as the primary source of truth for the local IDE to map dependencies and symbols accurately.
