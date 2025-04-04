# Task Manager Android App

An Android Task Manager application built using **Kotlin**, **MVVM architecture**, and **Room database**. It allows users to create, update, and mark tasks as completed. The app integrates with **Firebase Analytics**, **Firebase Crashlytics**, and consumes mock data from a REST API.

---

## 🚀 Setup & Run Instructions

1. **Clone the repository**

2. **Open in Android Studio**
   - Open the project in Android Studio.
   - Let Gradle sync.

3. **Add Google Services JSON**
   - Download your `google-services.json` from the [Firebase Console](https://console.firebase.google.com/).
   - Place it inside `app/` directory.

4. **Build & Run**
   - Run on a real device or emulator with internet access.

---

## 📦 Third-Party Library Integrations

| Library                | Purpose                                     |
|------------------------|---------------------------------------------|
| Room DB                | Local database to persist tasks             |
| Firebase Analytics     | Log custom user events                      |
| Firebase Crashlytics   | Capture and report app crashes              |
| Retrofit2 (Optional)   | Consume mock REST API for task sync         |
| Gson                   | Convert JSON to Kotlin data models          |

---

## 🛠 Design Decisions

- **Architecture**: MVVM with Repository pattern for clean separation of concerns.
- **Room DB**: Used to store tasks locally for offline access.
- **Firebase Analytics**: Logs task events like `task_added`, `task_completed`, `task_edited`.
- **Firebase Crashlytics**: Tracks app crashes and simulated DB crashes.
- **Mock API Integration**: Added sync functionality using Retrofit to simulate real-world REST API usage.
- **UI**: Built using XML layouts with Material Design components and FAB for task addition.

---

## 📸 Firebase Analytics Console Screenshots

> Add the following screenshots:

- Task Added Event
- Task Completed Event
- Task Edited Event

*(screenshots/analytics/screen recording reference here)*
https://drive.google.com/drive/folders/1nHd6aStQGaP4nzldU-UgYsC5-0ptro_C?usp=drive_link

---

## ✅ Features

- Add new tasks with custom title.
- Edit task title.
- Mark tasks as completed.
- Sync tasks from external API.
- Firebase Analytics logging.
- Crash reporting via Crashlytics.

---

> Developed by Sahil. For queries or issues email at sahil19750@gmail.com

