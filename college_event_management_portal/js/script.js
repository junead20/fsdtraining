// ===== College Event Management System - Main JavaScript =====

document.addEventListener('DOMContentLoaded', function () {

    // ===== Navbar Scroll Effect =====
    const navbar = document.querySelector('.navbar');
    if (navbar) {
        window.addEventListener('scroll', function () {
            if (window.scrollY > 50) {
                navbar.classList.add('scrolled');
            } else {
                navbar.classList.remove('scrolled');
            }
        });
    }

    // ===== Active Nav Link =====
    const currentPage = window.location.pathname.split('/').pop() || 'index.html';
    document.querySelectorAll('.nav-link').forEach(function (link) {
        const href = link.getAttribute('href');
        if (href === currentPage) {
            link.classList.add('active');
        }
    });

    // ===== Back to Top Button =====
    const backToTop = document.querySelector('.back-to-top');
    if (backToTop) {
        window.addEventListener('scroll', function () {
            if (window.scrollY > 400) {
                backToTop.classList.add('visible');
            } else {
                backToTop.classList.remove('visible');
            }
        });

        backToTop.addEventListener('click', function () {
            window.scrollTo({ top: 0, behavior: 'smooth' });
        });
    }

    // ===== Scroll Animations =====
    const observerOptions = {
        threshold: 0.1,
        rootMargin: '0px 0px -50px 0px'
    };

    const observer = new IntersectionObserver(function (entries) {
        entries.forEach(function (entry) {
            if (entry.isIntersecting) {
                entry.target.classList.add('animated');
                observer.unobserve(entry.target);
            }
        });
    }, observerOptions);

    document.querySelectorAll('.animate-on-scroll').forEach(function (el) {
        observer.observe(el);
    });

    // ===== Registration Form =====
    const registrationForm = document.getElementById('registrationForm');
    if (registrationForm) {
        registrationForm.addEventListener('submit', function (e) {
            e.preventDefault();

            // Get form values
            const studentName = document.getElementById('studentName').value.trim();
            const rollNumber = document.getElementById('rollNumber').value.trim();
            const branch = document.getElementById('branch').value;
            const email = document.getElementById('email').value.trim();
            const mobile = document.getElementById('mobile').value.trim();
            const eventSelection = document.getElementById('eventSelection').value;

            // Basic validation
            if (!studentName || !rollNumber || !branch || !email || !mobile || !eventSelection) {
                showAlert('Please fill in all fields.', 'danger');
                return;
            }

            // Email validation
            var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(email)) {
                showAlert('Please enter a valid email address.', 'danger');
                return;
            }

            // Mobile validation
            var mobileRegex = /^[0-9]{10}$/;
            if (!mobileRegex.test(mobile)) {
                showAlert('Please enter a valid 10-digit mobile number.', 'danger');
                return;
            }

            // Show success modal
            var modalBody = document.getElementById('successModalBody');
            if (modalBody) {
                modalBody.innerHTML = `
                    <div class="text-center mb-4">
                        <div style="width:80px;height:80px;border-radius:50%;background:rgba(0,212,170,0.1);display:flex;align-items:center;justify-content:center;margin:0 auto 20px;">
                            <i class="bi bi-check-circle-fill" style="font-size:2.5rem;color:#00D4AA;"></i>
                        </div>
                        <h4 style="font-family:'Outfit',sans-serif;font-weight:700;">Registration Successful!</h4>
                        <p style="color:#A7A9BE;">Your registration has been confirmed.</p>
                    </div>
                    <div style="background:rgba(108,99,255,0.05);border:1px solid rgba(108,99,255,0.1);border-radius:12px;padding:20px;">
                        <h6 style="font-family:'Outfit',sans-serif;font-weight:600;margin-bottom:16px;color:#8B85FF;">Registration Details</h6>
                        <table style="width:100%;color:#A7A9BE;font-size:0.9rem;">
                            <tr><td style="padding:6px 0;font-weight:600;color:#FFFFFE;">Name</td><td style="padding:6px 0;">${studentName}</td></tr>
                            <tr><td style="padding:6px 0;font-weight:600;color:#FFFFFE;">Roll Number</td><td style="padding:6px 0;">${rollNumber}</td></tr>
                            <tr><td style="padding:6px 0;font-weight:600;color:#FFFFFE;">Branch</td><td style="padding:6px 0;">${branch}</td></tr>
                            <tr><td style="padding:6px 0;font-weight:600;color:#FFFFFE;">Email</td><td style="padding:6px 0;">${email}</td></tr>
                            <tr><td style="padding:6px 0;font-weight:600;color:#FFFFFE;">Mobile</td><td style="padding:6px 0;">${mobile}</td></tr>
                            <tr><td style="padding:6px 0;font-weight:600;color:#FFFFFE;">Event</td><td style="padding:6px 0;">${eventSelection}</td></tr>
                        </table>
                    </div>
                `;
            }

            var successModal = new bootstrap.Modal(document.getElementById('successModal'));
            successModal.show();

            // Show success alert
            showAlert('🎉 Registration successful! Check your email for confirmation.', 'success');

            // Reset form
            registrationForm.reset();
        });
    }

    // ===== Contact Form =====
    const contactForm = document.getElementById('contactForm');
    if (contactForm) {
        contactForm.addEventListener('submit', function (e) {
            e.preventDefault();

            var name = document.getElementById('contactName').value.trim();
            var email = document.getElementById('contactEmail').value.trim();
            var message = document.getElementById('contactMessage').value.trim();

            if (!name || !email || !message) {
                showAlert('Please fill in all fields.', 'danger');
                return;
            }

            showAlert('✅ Message sent successfully! We will get back to you soon.', 'success');
            contactForm.reset();
        });
    }

    // ===== Alert Helper =====
    function showAlert(message, type) {
        var alertContainer = document.getElementById('alertContainer');
        if (!alertContainer) return;

        var alertEl = document.createElement('div');
        alertEl.className = 'alert alert-' + type + ' alert-dismissible fade show';
        alertEl.style.cssText = 'border-radius:12px;font-family:"Inter",sans-serif;border:none;';

        if (type === 'success') {
            alertEl.style.background = 'rgba(0,212,170,0.1)';
            alertEl.style.color = '#00F5C8';
            alertEl.style.border = '1px solid rgba(0,212,170,0.3)';
        } else {
            alertEl.style.background = 'rgba(255,101,132,0.1)';
            alertEl.style.color = '#FF6584';
            alertEl.style.border = '1px solid rgba(255,101,132,0.3)';
        }

        alertEl.innerHTML = message + '<button type="button" class="btn-close" data-bs-dismiss="alert" style="filter:invert(1);"></button>';
        alertContainer.prepend(alertEl);

        // Auto-dismiss after 5 seconds
        setTimeout(function () {
            if (alertEl.parentNode) {
                alertEl.classList.remove('show');
                setTimeout(function () {
                    if (alertEl.parentNode) alertEl.remove();
                }, 300);
            }
        }, 5000);
    }

    // ===== Gallery Modal =====
    document.querySelectorAll('.gallery-card').forEach(function (card) {
        card.addEventListener('click', function () {
            var img = this.querySelector('img');
            var title = this.querySelector('.gallery-overlay h6');
            var modalImg = document.getElementById('galleryModalImg');
            var modalTitle = document.getElementById('galleryModalTitle');

            if (modalImg && img) {
                modalImg.src = img.src;
                modalImg.alt = img.alt;
            }
            if (modalTitle && title) {
                modalTitle.textContent = title.textContent;
            }

            var galleryModal = new bootstrap.Modal(document.getElementById('galleryModal'));
            galleryModal.show();
        });
    });

    // ===== Counter Animation =====
    function animateCounters() {
        document.querySelectorAll('.stat-number').forEach(function (counter) {
            var target = parseInt(counter.getAttribute('data-target'));
            if (!target || counter.classList.contains('counted')) return;

            counter.classList.add('counted');
            var current = 0;
            var increment = target / 50;
            var suffix = counter.getAttribute('data-suffix') || '';

            var timer = setInterval(function () {
                current += increment;
                if (current >= target) {
                    current = target;
                    clearInterval(timer);
                }
                counter.textContent = Math.floor(current) + suffix;
            }, 30);
        });
    }

    // Trigger counter animation when hero section is visible
    var heroStats = document.querySelector('.hero-stats');
    if (heroStats) {
        var statsObserver = new IntersectionObserver(function (entries) {
            entries.forEach(function (entry) {
                if (entry.isIntersecting) {
                    animateCounters();
                    statsObserver.unobserve(entry.target);
                }
            });
        }, { threshold: 0.5 });

        statsObserver.observe(heroStats);
    }

    // ===== Smooth Scroll for anchor links =====
    document.querySelectorAll('a[href^="#"]').forEach(function (anchor) {
        anchor.addEventListener('click', function (e) {
            var targetId = this.getAttribute('href');
            if (targetId === '#') return;

            var targetEl = document.querySelector(targetId);
            if (targetEl) {
                e.preventDefault();
                targetEl.scrollIntoView({ behavior: 'smooth' });
            }
        });
    });

});
