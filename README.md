# Comicos 🦸

> An Android app for exploring comics information — built with modern Android development best practices.

[![Kotlin](https://img.shields.io/badge/Language-Kotlin-7F52FF.svg?logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose-4285F4.svg?logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Hilt](https://img.shields.io/badge/DI-Hilt-2EA043.svg)](https://dagger.dev/hilt/)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)
[![Hacktoberfest](https://img.shields.io/badge/Hacktoberfest-Contributor-orange.svg)](https://hacktoberfest.com)

---
<!--
## 📱 Screenshots

> _Add screenshots here. Tip: use a table to show multiple screens side by side._

| Comic List | Comic Detail |
|:----------:|:------------:|
| ![List](screenshots/list.png) | ![Detail](screenshots/detail.png) |

---
-->
## About

**Comicos** is an Android application that lets users browse and explore information about comics. Built as a personal project to demonstrate modern Android development with a clean, declarative UI and a scalable architecture.

The app fetches comic data from a remote API and presents it through a smooth, Compose-driven interface — putting into practice the same patterns used in production apps.

---

## Features

- 📚 Browse a list of comics with cover art and metadata
- 🔍 View detailed information for each comic (title, description, characters, etc.)
- 🌐 Real-time data fetched from a remote comics API
- ⚡ Fast, responsive UI built entirely with Jetpack Compose
- 🧹 Code quality enforced with ktlint

---

## Tech Stack

This project uses a fully modern Android stack:

| Layer | Technology |
|-------|-----------|
| **UI** | [Jetpack Compose](https://developer.android.com/jetpack/compose) — declarative UI toolkit |
| **Navigation** | [Compose Navigation](https://developer.android.com/jetpack/compose/navigation) |
| **DI** | [Dagger Hilt](https://dagger.dev/hilt/) — compile-time dependency injection |
| **Networking** | Retrofit / Ktor + [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization) |
| **Async** | [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) + Flow |
| **Architecture** | MVVM + Repository pattern |
| **Build** | Kotlin DSL (`build.gradle.kts`) + Version Catalog (`libs.versions.toml`) |
| **Code Quality** | [ktlint](https://github.com/pinterest/ktlint) |

---

## Architecture

The app follows **MVVM with a clean Repository layer**, matching Google's recommended Android architecture:

```
UI Layer (Compose Screens)
        ↓
ViewModel (StateFlow / UI State)
        ↓
Repository
        ↓
Remote Data Source (API Service)
```

```
comicos/
├── app/
│   └── src/main/java/com/m68476521/comicos/
│       ├── data/
│       │   ├── model/          # Data classes / DTOs
│       │   ├── remote/         # API service interface + HTTP client
│       │   └── repository/     # Repository implementation
│       ├── di/                 # Hilt modules
│       ├── ui/
│       │   ├── components/     # Reusable Compose components
│       │   ├── screens/        # Screen-level composables
│       │   └── theme/          # Material theme, colors, typography
│       └── MainActivity.kt
├── build.gradle.kts
├── gradle/
│   └── libs.versions.toml      # Centralized dependency versions
└── settings.gradle.kts
```

---

## Getting Started

### Prerequisites

- Android Studio **Hedgehog** or newer
- JDK **17**
- Android SDK **API 24** (min) / **API 34** (target)

### API Key Setup

This app connects to a comics API. You'll need to provide your own API key.

1. Get your key from `[API provider URL]`
2. Add it to your `local.properties` file (already in `.gitignore`):

```properties
# local.properties
API_KEY=your_api_key_here
```

> **Never commit your API key.** The `.gitignore` already excludes `local.properties`.

### Build & Run

```bash
git clone https://github.com/m68476521/comicos.git
cd comicos
```

Open in Android Studio, sync Gradle, and run on an emulator or device (API 24+).

---

## Code Quality

This project uses **ktlint** for Kotlin code style enforcement.

Run the linter manually:

```bash
./gradlew ktlintCheck      # check for violations
./gradlew ktlintFormat     # auto-fix formatting
```

---

## Contributing

Contributions are welcome — this project participates in **Hacktoberfest** 🎃

1. Fork the repo
2. Create your feature branch: `git checkout -b feature/your-feature`
3. Commit your changes: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature/your-feature`
5. Open a Pull Request

Please make sure `./gradlew ktlintCheck` passes before submitting.

---

## Author

**Miguel Orozco Delgado** — Senior Android Engineer

- 🌐 [m68476521.com](https://www.m68476521.com)
- 💼 [LinkedIn](https://linkedin.com/in/m-orozco-delgado)
- 🐙 [GitHub](https://github.com/m68476521)

---

## License

```
Copyright 2023 Miguel Orozco Delgado

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
