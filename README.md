# ModifierDemo — лабораторная работа №2

**Тема:** модификаторы Jetpack Compose. **Цель:** последовательно изучить создание цепочек Modifier, порядок операций, передачу параметров собственному компоненту и объединение через `then()`.

Источник задания: `C:/AndroidProjects/_course_materials/Lab_02.pdf` и все 8 страниц `Modifiers.pdf`. Все 16 учебных действий сохранены отдельными коммитами, после каждого выполнен настоящий `:app:assembleDebug`. Дополнительный этап 17 добавляет доступность и instrumented-тесты; этап 18 документирует результаты. **Сдача ещё не завершена: UI-проверку выполняет родительский агент, коммита `Finish project` пока нет.**

## Проект и версии

- Каталог: `C:/AndroidProjects/ModifierDemo`, ветка `master`, отдельный локальный Git-репозиторий без remote.
- Package/applicationId: `com.example.modifierdemo`; Activity: `com.example.modifierdemo/.MainActivity`.
- Kotlin + Compose + Material 3; `minSdk 27`, `compileSdk 37`, `targetSdk 37`.
- AGP `9.4.1`, Compose compiler plugin `2.2.10`, Compose BOM `2026.02.01`, Gradle wrapper `9.6.0`.
- SDK `C:/Android/Sdk`; JBR Android Studio `C:/Program Files/Android/Android Studio/jbr`.
- Версии взяты из доступного конфигурационного образца ComposeDemo только для чтения и подтверждены реальными сборками. Автообновлений SDK, библиотек и системных настроек не производилось.

## Запуск и сборка

Открыть эту папку в Android Studio, дождаться Gradle Sync, выбрать `app` и устройство API 27+. Preview: `DefaultPreview` в `MainActivity.kt`.

В Windows cmd, только для текущего процесса:

```bat
set "JAVA_HOME=C:\Program Files\Android\Android Studio\jbr"
gradlew.bat :app:assembleDebug
gradlew.bat :app:assembleDebugAndroidTest :app:testDebugUnitTest :app:lintDebug
```

В Git Bash аналогично: `JAVA_HOME='C:/Program Files/Android/Android Studio/jbr' ./gradlew :app:assembleDebug`.
В игнорируемом `local.properties` используется экранированный путь `sdk.dir=C\:/Android/Sdk`.
APK: `app/build/outputs/apk/debug/app-debug.apk`; test APK: `app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk`.

После готовности устройства родительскому агенту выполнить:

```bat
gradlew.bat :app:connectedDebugAndroidTest
C:\Android\Sdk\platform-tools\adb.exe install -r app\build\outputs\apk\debug\app-debug.apk
C:\Android\Sdk\platform-tools\adb.exe shell am start -n com.example.modifierdemo/.MainActivity
```

## История, обучение и доказательства

- `docs/STAGES.md` — название и полный hash каждого учебного коммита, по 2–4 предложения о действии и проверке.
- `docs/REQUIREMENTS.md` — матрица «требование → файл → коммит → проверка».
- `docs/THEORY.md` — краткая теория, уточнения лекции и вопросы для защиты.
- Внешний каталог: `C:/AndroidProjects/_lab02_evidence/ModifierDemo/`.
- `manifest.json` сопоставляет этап, название/полный hash коммита, APK, SHA-256 и лог сборки. `apks/01.apk`–`apks/16.apk` сохраняют исходные учебные дизайны, `17.apk` — доступную версию, `18.apk` — тот же интерфейс с документацией.
- `logs/01.log`–`logs/18.log` — настоящие сборки перед коммитами, не синтетические отчёты.
- `detach-verification.json`, `logs/detach-06.log`, `logs/detach-restored.log` — безопасный переход к этапу 06, сборка, возврат на master и повторная сборка.

### Безопасный просмотр старого коммита

Демонстрация выполнена на чистом дереве: с `432e9c8599023051db05d03b19d76539a937e646` к `1bb29f8fd010c0434fae46389deb05e49aa15e94` и обратно. Подтверждены detached HEAD, исходник старого дизайна, успешные сборки обоих состояний, точный возврат HEAD и чистота Git. При первой проверке побайтовый hash локального Kotlin-файла изменился из-за LF→CRLF при checkout; повторная проверка сравнила нормализованный текст, HEAD и чистоту, не меняя настройки Git.

Для самостоятельного повторения сначала проверить `git status --porcelain` (вывод пуст), записать текущую ветку и HEAD. Затем `git switch --detach <hash>`, изучить/собрать старый код, **не редактировать и не коммитить**, выполнить `git switch master` и сверить HEAD. Не применять reset --hard, clean или force.

## Фактически проверено

- [x] Каждый учебный этап реально собран и закоммичен отдельно; APK сохранены вне репозитория.
- [x] Оригинальный `vacation.jpg` скопирован побайтно, размер 320261 байт; ресурс не заменён.
- [x] `assembleDebugAndroidTest` успешно собирает instrumented APK.
- [x] `lintDebug --rerun-tasks`: успешен, **0 ошибок, 8 предупреждений**.
- [x] `testDebugUnitTest` выполнен, результат **NO-SOURCE**, а не «unit-тесты прошли». Приложение не содержит отдельной вычислительной логики; UI проверяется instrumented-тестами.
- [x] Переход в detached HEAD и возврат выполнены без потери истории.
- [ ] Пять instrumented-тестов реально выполнены на устройстве.
- [ ] Preview и реальные скриншоты всех промежуточных этапов проверены.
- [ ] После просмотра исторических APK восстановлен финальный APK, подтверждены отсутствие падения, рамка, высота, изображение и скругление.
- [ ] Финальные результаты добавлены в документы; создан содержательный `Finish project`.

`DemoScreenTest` проверяет видимость Hello Compose, описание картинки, работу CustomImage без modifier, передачу размера и внутреннюю высоту текста после `then()`. До реализации API сохранены неуспешные компиляции тестов (`02-test-red.log`, `17-test-red.log`), после реализации тесты компилируются; **это не доказательство runtime RED/GREEN** и не замена connected-тестам.

### Предупреждения и исправленная проблема

Первый lint обнаружил `PropertyEscape` в локальном пути SDK; исправлен только `local.properties`. Повторный обычный запуск использовал кэш старого lint-отчёта, поэтому выполнен `--rerun-tasks`, после чего ошибок нет. Остались 5 уведомлений об обновлениях зависимостей (версии намеренно зафиксированы), `DataExtractionRules`, `IconLocation` для учебного `res/drawable/vacation.jpg` и `MissingApplicationIcon`; они не подавлены и перечислены в отчёте. Приложение не хранит пользовательских данных; release-публикация не входит в задание.

## Границы работы

ComposeDemo использован только как read-only образец wrapper/config; RowColDemo не изменялся. Эмулятор этим исполнителем не запускался, команды устройства не выполнялись, GitHub не использовался. `local.properties`, `.gradle/`, `.idea/`, `build/`, ключи и `.env` исключены из Git. Пиксельные совпадения со скриншотами лекции не обещаются до реального визуального контроля: доступная ширина, плотность и масштаб шрифта влияют на результат.
