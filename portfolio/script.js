const header = document.querySelector("[data-header]");
const loader = document.querySelector("[data-loader]");
const loaderBar = document.querySelector("[data-loader-bar]");
const loaderCount = document.querySelector("[data-loader-count]");

document.body.classList.add("is-loading");

const updateHeader = () => {
  header.classList.toggle("is-scrolled", window.scrollY > 12);
};

let progress = 0;
const loaderTimer = window.setInterval(() => {
  progress = Math.min(progress + Math.ceil(Math.random() * 12), 100);
  loaderBar.style.width = `${progress}%`;
  loaderCount.textContent = `${progress}%`;

  if (progress >= 100) {
    window.clearInterval(loaderTimer);
    window.setTimeout(() => {
      loader.classList.add("is-hidden");
      document.body.classList.remove("is-loading");
    }, 320);
    window.setTimeout(() => loader.remove(), 900);
  }
}, 90);

window.addEventListener("scroll", updateHeader, { passive: true });
updateHeader();
