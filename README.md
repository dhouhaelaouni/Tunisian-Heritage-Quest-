# Tunisian-Heritage-Quest-
an android studio game 
# Tunisia Heritage Quest 🏛️

## Project Overview
Tunisia Heritage Quest is an interactive Android application built with **Jetpack Compose**. It aims to promote Tunisian historical monuments and cities through an engaging image-identification quiz. The app features 6 categories of heritage, multiple difficulty levels, a scoring system with a timer, and a responsive design for both phones and tablets.

## Architecture Explanation
The project follows modern Android development best practices:
- **Architecture Pattern**: MVVM (Model-ViewModel-ViewModel) with Unidirectional Data Flow (UDF).
- **View Layer**: 100% Jetpack Compose for a modern, declarative UI.
- **State Management**: `StateFlow` is used in the `QuizViewModel` to emit UI states that the Composables observe.
- **Data Layer**: A `QuestionRepository` abstracts the data source, allowing for easy expansion of question sets.
- **Navigation**: The `Compose Navigation` component handles all screen transitions and argument passing (e.g., passing Category and Difficulty to the Quiz screen).

## Setup Instructions
1. Clone the repository or unzip the project file.
2. Open the project in **Android Studio (Ladybug or newer)**.
3. Ensure you have the **Android SDK 36** (API 36) installed.
4. Sync the project with Gradle files.
5. Run the app on an emulator or a physical device (Minimum SDK: 24).
6. To run tests: Right-click the `com.example.dhouhaelaouni` folder in `src/test` or `src/androidTest` and select **"Run 'All Tests'"**.

## Known Issues
- All categories are functional, but some images use high-quality placeholders where specific site photos were unavailable.
- The 2.5s Splash Screen is automatic and cannot be skipped manually (intentional for branding).
