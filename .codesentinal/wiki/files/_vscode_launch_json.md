# Purpose
To provide local development environment configurations for the Visual Studio Code editor, enabling consistent debugging and execution settings for the project.

# Responsibilities
Defines launch configurations that allow developers to start, run, and debug the application directly from the VS Code interface.

# Architectural Role
Application Component (Configuration).

# Critical Review Context
Focus on ensuring that debug arguments, environment variables, and entry points remain aligned with the current business logic and project structure.

# Maintenance Notes
Updates to this file should reflect changes in project startup requirements, such as new environment variable dependencies or changes to the primary application entry point.

# Known Constraints
Configurations are specific to the Visual Studio Code environment and may not reflect production execution parameters.

# Related Components
Application entry points and core execution scripts.

# Repository Memory
This file serves as the primary source of truth for local debugging behavior. When reviewing PRs, verify that any changes to application initialization or dependency injection are mirrored in these launch configurations to maintain developer productivity.
