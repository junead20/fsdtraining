
document.addEventListener('DOMContentLoaded', () => {
    const f = document.getElementById('regForm');
    if (f) { f.addEventListener('submit', e => { e.preventDefault(); document.getElementById('success').classList.remove('d-none'); f.reset(); }); }
});
