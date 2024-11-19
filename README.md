# **Progeren Application**

This repository contains a portion of the codebase for an **Progeren Application**, designed to streamline the process of performing energy audits in various facilities. The application replaces manual processes with digital tools to improve efficiency, accuracy, and data management. 

## **About the Application**
The application is structured to support various functionalities such as:
- Recording energy, water, and other utility data across multiple facilities.
- Managing sections and findings with real-time updates.
- Allowing users to navigate through lists of data (via RecyclerView) and edit detailed records on dedicated screens.
- Exporting audit results to Excel and synchronizing data with cloud storage.

## **Focus of this Repository**
This repository specifically showcases the implementation of the **data layer** using **Room** as the local database solution. 

### **Key Features of Room Implementation**
1. **Build Logic**: 
   - Modularized build configuration using custom Gradle plugins for consistency and reusability.
   - Simplifies dependency management for Room, Hilt, and other libraries.

2. **Database Design**:
   - Uses **Room Database** with a well-structured schema for various entities such as `Lighting`, `Climate Equipment`, and `Findings`.
   - Integrates `@TypeConverters` for handling custom data types like complex models or lists.

3. **Repository Architecture**:
   - Implements a **generic repository pattern** (`FeatureRepository<T>`) to handle data for different entities uniformly.
   - Combines local and remote repositories to provide a consistent and extensible data access layer.

4. **Base DAO**:
   - Includes a `BaseDao` that provides reusable CRUD operations, reducing boilerplate code and ensuring consistency.

5. **Data Transformation**:
   - Handles conversion between data models (Room entities) and domain models, ensuring clear separation of concerns between the database and business logic.

## **How to Use This Repository**
This repository is intended to highlight the **Room-based local data source** implementation. It demonstrates:
- The database schema and DAOs for different entities.
- The repository pattern used to manage data operations.
- Build logic configuration for modular development.

## **Why This Matters**
The modularized and generic approach used in this application ensures scalability and maintainability. It simplifies the addition of new entities and features, making it an excellent example of clean architecture principles in Android development.

---

Feel free to explore the code and reach out if you have any questions or feedback. This repository aims to showcase not only technical expertise but also a thoughtful design process for solving real-world problems.
