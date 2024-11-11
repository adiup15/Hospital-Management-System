document.addEventListener('DOMContentLoaded', () => {
    // Navigation handling
    const sidebarLinks = document.querySelectorAll('.sidebar li');
    const pages = document.querySelectorAll('.page');

    function navigateToPage(pageId) {
        // Remove active class from all links and pages
        sidebarLinks.forEach(l => l.classList.remove('active'));
        pages.forEach(p => p.classList.remove('active'));

        // Add active class to corresponding link and page
        const link = document.querySelector(`[data-page="${pageId}"]`);
        const page = document.getElementById(pageId);

        if (link && page) {
            link.classList.add('active');
            page.classList.add('active');
        }
    }

    // Handle sidebar navigation
    sidebarLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            const pageId = link.getAttribute('data-page');
            if (pageId) {
                navigateToPage(pageId);
                // Update URL hash without triggering scroll
                history.pushState(null, '', `#${pageId}`);
            }
        });
    });

    // Handle direct URL navigation and back/forward buttons
    window.addEventListener('hashchange', () => {
        const pageId = window.location.hash.slice(1) || 'dashboard';
        navigateToPage(pageId);
    });

    // Initial navigation based on URL hash
    const initialPage = window.location.hash.slice(1) || 'dashboard';
    navigateToPage(initialPage);

    // Search functionality
    const searchInput = document.querySelector('.search-bar input');
    if (searchInput) {
        searchInput.addEventListener('input', (e) => {
            const searchTerm = e.target.value.toLowerCase();
            const tableRows = document.querySelectorAll('tbody tr');

            tableRows.forEach(row => {
                const text = row.textContent.toLowerCase();
                row.style.display = text.includes(searchTerm) ? '' : 'none';
            });
        });
    }

    // Add button handlers
    const addButtons = document.querySelectorAll('.add-btn');
    addButtons.forEach(button => {
        button.addEventListener('click', () => {
            alert('Add functionality to be implemented');
        });
    });

    // Edit button handlers
    const editButtons = document.querySelectorAll('.edit-btn');
    editButtons.forEach(button => {
        button.addEventListener('click', () => {
            alert('Edit functionality to be implemented');
        });
    });

    // Delete button handlers
    const deleteButtons = document.querySelectorAll('.delete-btn');
    deleteButtons.forEach(button => {
        button.addEventListener('click', () => {
            if (confirm('Are you sure you want to delete this record?')) {
                alert('Delete functionality to be implemented');
            }
        });
    });
});