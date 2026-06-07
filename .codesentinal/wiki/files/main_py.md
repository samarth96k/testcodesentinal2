# Purpose
The purpose of `main.py` is to define the core domain entities `BankAccount` and `BankSystem` and serve as the execution entrypoint for the application.

# Responsibilities
- Implementing the fundamental banking logic and account management structures.
- Providing the primary interface for system-wide operations through `BankSystem`.

# Architectural Role
Application Entrypoint.

# Critical Review Context
When reviewing this file, focus strictly on business logic correctness. Ensure that balance manipulations, account state transitions, and interaction rules between `BankAccount` and `BankSystem` adhere to expected financial domain constraints.

# Maintenance Notes
- This file acts as the repository's foundation; changes here likely affect the entire system's behavioral integrity.
- Verify that any new business rules added to `BankAccount` are properly integrated into the `BankSystem` orchestrator.

# Known Constraints
- The current implementation serves as the primary system definition and operates without external dependencies.

# Related Components
- `BankAccount`: Core entity defining individual account state.
- `BankSystem`: Orchestrator managing multiple `BankAccount` instances.

# Repository Memory
- Initial repository implementation establishes the foundational banking model.
- Logic is centralized within this file; prioritize clarity and strict adherence to defined financial operations during future modifications.
