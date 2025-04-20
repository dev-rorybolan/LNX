# LNX Language Support

LNX is a custom, Kotlin-inspired programming language with a fun syntax twist.  
This extension adds syntax highlighting and build task support for `.lnx` files in **Visual Studio Code**.

---

## ✨ Features

- Custom syntax highlighting for `.lnx` files (using TextMate grammar)
- Easy transpilation to Kotlin via a bundled preprocessor
- Build & run `.lnx` code directly with a single keyboard shortcut
- Kotlin-flavored syntax with playful keywords:
  - `function` → `fun`
  - `objectBlueprint` → `class`
  - `permanent` → `val`
  - `mutable` → `var`
  - `runIf` → `if`
  - `runIfNot` → `else`
  - `loopFor`, `loopWhile` → `for`, `while`

---

## 📦 Installation

1. **Download the `.vsix` file** from the lnx folder or build it manually with `vsce package`.
2. Open **Visual Studio Code**.
3. Hit `Ctrl+Shift+P` (or `Cmd+Shift+P` on macOS) and select:  
   `Extensions: Install from VSIX...`
4. Choose the `.vsix` file and install.
5. Restart VSCode if needed.
6. Hit `Ctrl+Shift+P` (or `Cmd+Shift+P` on macOS) and select:  
   `Tasks: Configure Task: Create tasks.json from template: Others`
7. Copy the code from the tasks.json in this repository.
   
You’re good to go! `.lnx` files will now have full highlighting and run support.

---

## ⚙️ Requirements

- **Visual Studio Code**
- **Java (JDK)** and **Kotlin compiler (`kotlinc`)** installed and available in your `PATH`

---

## 🚀 How to Run LNX Code

1. Open any `.lnx` file in VSCode.
2. Press `Ctrl+Shift+B` (or `Cmd+Shift+B` on macOS).
3. Your code will:
   - Be transpiled into `.kt`
   - Compiled to a runnable `.jar`
   - Executed automatically
4. Output will appear in the terminal.

> **Note:** This only works inside VSCode using the included `tasks.json` build config.

---

## 📁 Included Files

- `src/`
  - Your `.lnx` scripts and `preprocessor.jar`
- `lnx/`
  - VSCode syntax highlighting files (`tmLanguage.json`, `language-configuration.json`)

- `tasks.json`
    to support the build shortcut

---

## 💡 Tips

- You can modify or extend highlighting by editing `lnx/tmLanguage.json`.

---

## 📜 License

MIT or something fun and chill. Just don't sell it to Microsoft and we're cool.

---

Happy coding, and welcome to the world of LNX! 
