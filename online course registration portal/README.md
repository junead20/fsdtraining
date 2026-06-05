# 🎓 Skill Academy — Online Course Registration Portal

A responsive, modern web application for a training institute where students can explore courses, view detailed syllabi, and register online. Built with **HTML5**, **CSS3**, **Bootstrap 5.3**, **JavaScript**, and **Font Awesome 6**.

---

## 📋 Table of Contents

- [Features](#-features)
- [Pages Overview](#-pages-overview)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Bootstrap Components Used](#-bootstrap-components-used)
- [How to Run](#-how-to-run)
- [Screenshots](#-screenshots)

---

## ✨ Features

- **Responsive Design** — Fully responsive across desktop, tablet, and mobile devices
- **Premium UI/UX** — Modern gradients, glassmorphism navbar, smooth hover animations, and custom color palette
- **Dynamic Course Modal** — Click "View Details" on any course card to view syllabus, duration, and fee in a modal
- **Smart Registration** — URL query parameters auto-select the chosen course (e.g., `?course=Python%20Programming`)
- **Interactive Filters** — Filter courses by category (Development, Data & AI, Cloud) on the Courses page
- **Form Validation** — Client-side validation on Registration and Contact forms with success alerts
- **Login Modal** — Bootstrap modal with email/password fields and basic validation
- **Testimonial Carousel** — Auto-sliding carousel showcasing student reviews with ratings
- **Google Maps Embed** — Interactive map showing institute location on the Contact page
- **Timeline Component** — Custom CSS timeline showing institute milestones on the About page

---

## 📄 Pages Overview

| # | Page | File | Description |
|---|------|------|-------------|
| 1 | **Home** | `index.html` | Hero banner, featured courses (6 cards), testimonial carousel, footer |
| 2 | **Courses** | `courses.html` | All courses with category filter tabs and enrollment links |
| 3 | **Registration** | `registration.html` | Student enrollment form with validation and success alert |
| 4 | **About Us** | `about.html` | Institute history timeline, vision/mission cards, faculty profiles |
| 5 | **Contact Us** | `contact.html` | Contact form, address info cards, embedded Google Map |

---

## 🛠 Tech Stack

| Technology | Purpose |
|------------|---------|
| HTML5 | Semantic page structure |
| CSS3 | Custom styling, animations, gradients, transitions |
| Bootstrap 5.3.3 | Responsive grid, navbar, cards, modals, carousel, forms |
| JavaScript (ES6) | DOM manipulation, event handling, dynamic modals, URL parsing |
| Font Awesome 6.4 | Icons for navigation, cards, forms, and footer |
| Google Fonts | Plus Jakarta Sans typography |

---

## 📁 Project Structure

```
online course registration portal/
├── index.html          # Home Page
├── courses.html        # Courses Listing Page
├── registration.html   # Student Registration Form
├── about.html          # About Us Page
├── contact.html        # Contact Us Page
├── README.md           # Project Documentation
├── css/
│   └── style.css       # Custom Stylesheet (variables, animations, layouts)
└── js/
    └── script.js       # Interactive Logic (modals, filters, forms, URL params)
```

---

## 🧩 Bootstrap Components Used

- ✅ **Navbar** — Responsive sticky navigation with toggler
- ✅ **Cards** — Course cards, faculty cards, testimonial cards, contact info cards
- ✅ **Forms** — Registration form, contact form, login form
- ✅ **Buttons** — Primary, outline, warning, secondary styled buttons
- ✅ **Alerts** — Success alerts for registration and contact form submission
- ✅ **Modal** — Login modal, dynamic course details modal
- ✅ **Carousel** — Testimonials carousel with indicators and controls
- ✅ **Grid System** — Responsive `row`/`col-*` layouts on every page

---

## 🚀 How to Run

1. Clone or download this repository
2. Open the project folder in **VS Code**
3. Install the **Live Server** extension (if not already installed)
4. Right-click on `index.html` → **Open with Live Server**
5. The website will open in your default browser at `http://localhost:5500`

---

## 📸 Screenshots

### Home Page
![Home Page](screenshots/home.png)

### Courses Page
![Courses Page](screenshots/courses.png)

### Registration Page
![Registration Page](screenshots/registration.png)

### About Us Page
![About Us Page](screenshots/about.png)

### Contact Us Page
![Contact Us Page](screenshots/contact.png)

---

## 👨‍💻 Author

**Skill Academy Training Institute**  
Hyderabad, India

---

> Built with ❤️ using HTML, CSS, JavaScript & Bootstrap 5