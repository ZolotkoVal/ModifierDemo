# Соответствие требованиям

## Результат повторной приёмки

Все 18 сохранённых APK проверены по SHA-256 и сопоставлены с коммитами и успешными логами сборок. Для каждого есть успешный запуск и настоящий скриншот в `_lab02_evidence/ModifierDemo/device/`; все скриншоты осмотрены при возобновлении работы. Пять Android-тестов финального интерфейса выполнены на Pixel_API_34 через adb: `OK (5 tests)`. Подробности и ограничения находятся в `VERIFICATION.md`.

Ниже сохранён исходный поэтапный реестр; фраза «UI ожидается» описывает состояние на момент создания учебного коммита, а не текущую приёмку. Теперь каждому этапу соответствует `device/NN.png`, `device/NN.xml`, `device/NN.log` и запись PASS в `device-results.json`. Preview Android Studio отдельно не проверялся.

| Требование | Файл | Коммит | Проверка |
|---|---|---|---|
| 01: Create ModifierDemo Empty Activity | `app/build.gradle.kts; AndroidManifest.xml` | `2f6bd5699a6e` | assembleDebug: exit 0; UI ожидается |
| 02: Show Hello Compose in DemoScreen | `app/src/main/java/com/example/modifierdemo/MainActivity.kt` | `5861b751c521` | assembleDebug: exit 0; UI ожидается |
| 03: Create empty Modifier chain | `app/src/main/java/com/example/modifierdemo/MainActivity.kt` | `66500a578349` | assembleDebug: exit 0; UI ожидается |
| 04: Apply padding modifier to greeting | `app/src/main/java/com/example/modifierdemo/MainActivity.kt` | `568cf85e8122` | assembleDebug: exit 0; UI ожидается |
| 05: Add border after padding | `app/src/main/java/com/example/modifierdemo/MainActivity.kt` | `5b4b5fe08d7e` | assembleDebug: exit 0; UI ожидается |
| 06: Preserve incoming modifier and place border outside padding | `app/src/main/java/com/example/modifierdemo/MainActivity.kt` | `1bb29f8fd010` | assembleDebug: exit 0; UI ожидается |
| 07: Pass greeting modifier positionally | `app/src/main/java/com/example/modifierdemo/MainActivity.kt` | `16cc37cc945f` | assembleDebug: exit 0; UI ожидается |
| 08: Place border inside padding | `app/src/main/java/com/example/modifierdemo/MainActivity.kt` | `ef49518ec3f8` | assembleDebug: exit 0; UI ожидается |
| 09: Introduce CustomImage composable | `app/src/main/java/com/example/modifierdemo/MainActivity.kt` | `30e17bde588b` | assembleDebug: exit 0; UI ожидается |
| 10: Add required CustomImage modifier parameter | `app/src/main/java/com/example/modifierdemo/MainActivity.kt` | `c766492a6e36` | assembleDebug: exit 0; UI ожидается |
| 11: Make CustomImage modifier optional | `app/src/main/java/com/example/modifierdemo/MainActivity.kt` | `57ff4bd30cba` | assembleDebug: exit 0; UI ожидается |
| 12: Forward CustomImage modifier to Image | `app/src/main/java/com/example/modifierdemo/MainActivity.kt` | `abce6f94aba5` | assembleDebug: exit 0; UI ожидается |
| 13: Import original vacation drawable | `app/src/main/res/drawable/vacation.jpg` | `fa75bc4c8980` | assembleDebug: exit 0; UI ожидается |
| 14: Compose greeting spacer and vacation image | `app/src/main/java/com/example/modifierdemo/MainActivity.kt` | `52fa1399c8dc` | assembleDebug: exit 0; UI ожидается |
| 15: Pad size and round vacation image | `app/src/main/java/com/example/modifierdemo/MainActivity.kt` | `eb54ad6da535` | assembleDebug: exit 0; UI ожидается |
| 16: Combine text modifiers with then | `app/src/main/java/com/example/modifierdemo/MainActivity.kt` | `0f89b29aac99` | assembleDebug: exit 0; UI ожидается |
| 17: Add accessible image descriptions and Compose UI tests | `MainActivity.kt; DemoScreenTest.kt; strings.xml` | `432e9c859902` | assembleDebug: exit 0; UI ожидается |

Полные SHA-256 APK и commit IDs: внешний `manifest.json`. Контроль detach/возврата: `detach-verification.json`, логи `detach-06.log` и `detach-restored.log`.
