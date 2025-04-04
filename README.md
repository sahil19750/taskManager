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

*(screenshots/analytics/ reference here)*
https://drive.google.com/drive/folders/1nHd6aStQGaP4nzldU-UgYsC5-0ptro_C?usp=drive_link


---

## 📹 Mobile Screen Recording of Crash

> Record your device using screen recording while performing:

- Manual crash via "Force Crash" button
- Illegal Room DB crash via "DB Crash" button

**Upload the screen recording in `/media/recordings/` and link it here.**

---

## 💥 Firebase Crashlytics Screenshots

> Add screenshots showing the logs and crash traces from Firebase Crashlytics.

*(Place them in `/screenshots/crashlytics/`)*

---

## 📡 Network Performance Screenshots

> After syncing tasks from the mock API (`https://mocki.io/v1/8439bce9-1555-4a9e-a146-8de2e4d3cdbc`), add screenshots of Firebase Performance Monitoring's network traces.

*(Place them in `/screenshots/performance/`)*

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

