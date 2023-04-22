# Movie-platform

This project aims to implement a versatile movie recommendation application that allows users to assume multiple roles. Built using Maven and Jaxa FX, the application has a user-friendly graphical interface, ensuring ease of use. The login/register page enables clients to choose between being a user or an administrator, with the latter managing the movie dataset.

The platform provides a personalized recommendation stream that relies on a user's liked movies, facilitating the discovery of new movies they might enjoy. By liking movies from a PostgreSQL database, the system can suggest similar movies to the user's feed. Initially, the feed contains random movies if no movie is liked, but new similar ones get added to the top of the list based on likes.

The application's graphical interface opens with a Login/Register page that offers two user types - Admin and User - with different roles. Admins can add movies to the database, while Users can search for movies in the database, rate them, and view their feed.

This application was developed for the MIP lab (Medii și instrumente de programare).
