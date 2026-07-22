# NyaySahay

**Offline-first Indian legal aid and emergency resource application for Android.**

NyaySahay is an Android application built to provide quick access to essential legal information, emergency contacts, first aid guidance, and state-wise legal aid directories during situations where internet connectivity may be unreliable.

The application stores all resources locally on the device, allowing users to access information without an internet connection after installation.

---

## Features

### 📖 Know Your Rights
- Constitutional rights relevant to peaceful assembly
- Police procedures and detention rights
- Important provisions of the Bharatiya Nyaya Sanhita (BNS)
- Plain-language explanations

### ⚖️ State-wise Legal Aid Directory
- Browse advocates by state
- Search by name, city, or phone number
- One-tap calling directly from the app

### ☎️ Emergency Contacts
Includes quick access to important national and regional helplines including:
- 112 Emergency Response Support System
- Police
- Ambulance
- Fire Services
- Women's Helpline
- Child Helpline
- Citizen Helpline
- District Control Room
- Maharashtra Control Room

### 🩹 First Aid
Quick-reference first aid guidance for common emergency situations.

### ✅ Protest Checklist
A concise preparation checklist covering:
- Essential documents
- Safety items
- Emergency contacts
- General preparedness

### 🚨 Emergency SOS
One-tap access to the Android dialer with **112** pre-filled.

---

## Offline First

One of the primary goals of the project was ensuring that essential information remains available even without internet connectivity.

The app uses:

- Local JSON files
- Local CSV files
- Android Assets
- No login
- No cloud storage
- No backend server
- No analytics

Everything is packaged directly inside the APK.

---

## Technology Stack

- Java
- Android Studio
- RecyclerView
- RecyclerView Adapter
- RecyclerView Search
- JSON
- CSV
- Android Intents
- Material Design Components
- XML Layouts

---

## Project Structure

```
app/
├── java/
│   ├── activities/
│   ├── adapters/
│   ├── model/
│   └── utils/
│
├── assets/
│   ├── rights.json
│   ├── contacts.json
│   ├── firstaid.json
│   ├── checklist.json
│   └── lawyers/
│       ├── delhi.csv
│       ├── gujarat.csv
│       ├── maharashtra.csv
│       ├── ...
│
└── res/
    ├── layout/
    ├── drawable/
    └── mipmap/
```

## Installation

### Android

Download the latest APK from the Releases page.

Install the APK on your Android device.

If prompted:

```
Settings → Allow installation from this source
```

The application works completely offline after installation.

---

## Legal Aid Directory

The legal aid directory has been compiled from publicly circulated volunteer spreadsheets shared by legal aid networks and community organizations.

The application reorganizes these resources into a searchable offline format.

Users are encouraged to independently verify contact details where possible, as information may change over time.

---

## Disclaimer

This application provides general legal and safety information for educational and awareness purposes only.

It is **not** legal advice and should not be considered a substitute for consultation with a qualified advocate or emergency service.

Laws, procedures, and contact information may change over time.

---

## Future Work

- iOS version
- Progressive Web App (PWA)
- Automatic directory updates
- Multilingual support
- Dark mode
- Location-aware legal aid recommendations
- Accessibility improvements

---

## Contributing

Suggestions, bug reports, and pull requests are welcome.

If you notice incorrect legal information, outdated contact details, or have ideas for improving usability, please open an issue.

---

## Authors

**Divij Butte**

University of Illinois Urbana-Champaign  
B.S. Aerospace Engineering | Minor in Computer Science

GitHub: https://github.com/divijb45

LinkedIn: https://linkedin.com/in/divij-butte/

---

## Acknowledgements

Special thanks to the volunteers, legal aid organizations, and community members who compiled and circulated publicly available legal resources, making this project possible.

Content review and legal guidance were provided in collaboration with a law student to improve clarity and organization.
