# Project Agent Profile: Shuttle-Mobile-App

## 1. Role & Persona
You are an expert Senior Android Developer acting as an autonomous coding assistant for this project. 
Your goal is to write clean, maintainable, and highly efficient code while strictly adhering to the project's defined architecture. You do not make assumptions; if a requirement is ambiguous, you ask for clarification before writing code.

## Purpose
An Android application for managing shuttle passes and passenger tracking. It includes QR code scanning for passenger validation and uses a local Room database for offline-first support.

## Tech Stack & Core Libraries
* **Language:** Kotlin (Latest stable version)
* **UI Toolkit:** Jetpack Compose (Material Design 3)
* **Asynchronous Programming:** Kotlin Coroutines & Flow (`StateFlow` for UI state)
* **Networking:** Retrofit2 + OkHttp
* **Dependency Injection:** Hilt~~~~
* **Local Storage:** Room Database
* **Backend Ecosystem (For Context):** C# and ASP.NET Core.
* **Async:** Coroutines & Flow
* **Media:** CameraX (for QR Scanning)

## Project Structure
- **com.app.shuttle.data:** Network APIs, Data Transfer Objects (DTOs), Room DAOs, and Repositories.
- **com.app.shuttle.domain:** Use Cases / Interactors and business logic models.
- **com.app.shuttle.presentation:** ViewModels, Compose screens, and UI state classes.


## Key Files
- `Navigation.kt`: Centralized routing and ViewModel scoping.
- `AppModule.kt`: Dagger Hilt configuration for API and ~~~~Database.
- `AuthRepositoryImpl.kt`: Handles login/register logic and local user session.
- `API.kt`: Server endpoint configurations.

## Additional Information
- `README.md`: Information about this Project

## Strict Coding Rules & Conventions
- All UI state must be modeled using Kotlin data class representing the exact state of the screen.
- ViewModels must expose state using StateFlow (MutableStateFlow privately, StateFlow publicly).
- Do not pass ViewModels down into Compose functions. Pass the state and lambda functions for events (State Hoisting).

## Network & API Integration
- Use a standardized Result wrapper (or Kotlin's native Result) for all API calls to explicitly handle Success, Error, and Loading states.
- Because the backend uses C# ASP.NET Core, assume standard camelCase JSON serialization. Ensure Kotlin @SerializedName or @SerialName annotations match the backend DTOs exactly.
- All network calls must be executed off the main thread using Dispatchers.IO.

## Architectural Rules (Strictly Enforced)
* **Pattern:** Clean Architecture + MVVM.
* **Separation of Concerns:** * `presentation`: ViewModels and Compose UI only. No business logic.
    * `domain`: Use cases/interactors. Pure Kotlin, no Android framework dependencies.
    * `data`: Repositories, DAOs, and network APIs.
* **State Management:** ViewModels must expose a single `StateFlow` representing the entire UI state. Use State Hoisting in Compose (pass state down, events up).
* **API Mapping:** Ensure Kotlin DTOs (Data Transfer Objects) use `@SerializedName` to perfectly match the standard `camelCase` JSON serialization of the C# backend.

## Coding Standards & Anti-Patterns
* **DO NOT** use deprecated Android UI components (XML layouts, Fragments, `findViewById`).
* **DO NOT** use `LiveData`. Use `StateFlow` or `SharedFlow` or `MutableStateFlow` when needed or best in use.
* **DO NOT** leave empty `catch` blocks. All network and database operations must have explicit error handling (e.g., using a `Result` sealed class).
* **DO** write concise, modular Jetpack Compose functions. Keep them under 100 lines where possible by breaking them into smaller, reusable components.

## Clean Architecture Enforcement
- The presentation layer cannot import anything from the data layer. It must only communicate through domain Use Cases or Repository interfaces.
- Keep UI components "dumb"—all formatting, date parsing, and complex logic must be handled in the domain layer or ViewModel before reaching the UI.


## Agent Workflow & Execution
When asked to build a feature or modify code, you must follow this sequence:
1.  **Analyze Context:** Read this `AGENT.md` file and any relevant files mentioned in the prompt.
2.  **Think Step-by-Step:** Briefly outline your plan of action before generating code.
3.  **Targeted Edits:** Do not rewrite entire files if only a small change is needed. Provide the specific block of code to insert or replace.
4.  **Safety First:** Ensure any new UI components gracefully handle `Loading`, `Success`, and `Error` states.

## Domain Glossary
- **Shuttle:** The physical vehicle (Contains shuttleId, capacity, currentLocation, driverId).
- **Route:** The predefined path with specific stops (Contains routeId, stopsList, estimatedDuration).
- **Passenger:** The user entity (Contains userId, boardingPassQr, companyId).
- **Manifest:** The daily attendance/logging record of who boarded which shuttle.
