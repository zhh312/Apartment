# Apartment Rental Platform

## Overview
The **Apartment Rental Platform** is a comprehensive system that includes both a **mobile application** for tenants and a **backend management system** for administrators. The platform streamlines apartment searching, viewing appointments, lease management, and property administration.

## Tech Stack
- **Frontend:** Vue 3
- **Backend:** Spring Boot, Spring MVC, MyBatis, MyBatis Plus
- **Database:** MySQL
- **Caching:** Redis
- **Object Storage:** MinIO

## Features
### Mobile Application
- **Property Search**: Search apartments based on location, rent, and amenities.
- **Viewing Appointments**: Schedule in-person visits to apartments.
- **Lease Management**: View lease details, request extensions or terminations.
- **Browsing History**: Track previously viewed apartments.

### Backend Management System
- **Apartment Management**: Add, update, and remove apartments.
- **Room Management**: Manage individual room details within apartments.
- **Property Attributes**: Configure amenities and facilities.
- **Viewing Management**: Handle viewing appointment requests.
- **Lease Management**: Generate, modify, and terminate lease contracts.
- **User Management**: Administer user accounts for both tenants and system operators.

## Core Business Process
The platform follows a structured rental process:
1. **Sign Lease** → 2. **Lease Active** → 3. **Renewal or Termination** → 4. **Lease Completion**

There are 7 lease statuses: **Pending Confirmation, Active, Canceled, Expired, Termination Pending, Terminated, Renewal Pending**.

## Installation & Setup
### Backend (Spring Boot)
1. Clone the repository:
   ```sh
   git clone https://github.com/zhh312/Apartment.git
   cd Apartment/backend
   ```
2. Update **application.properties**:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/apartment_rental
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```
3. Run the application:
   ```sh
   mvn spring-boot:run
   ```

### Frontend (Vue 3)
1. Navigate to the frontend directory:
   ```sh
   cd Apartment/rentHouseAdmin
   cd Apartment/rentHouseH5
   ```
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start the frontend:
   ```sh
   npm run dev
   ```

### Database Setup
1. Create the database:
   ```sql
   CREATE DATABASE apartment_rental;
   ```
2. The system will automatically generate tables using MyBatis Plus.

## Deployment
The project follows a structured **development lifecycle**:
1. Requirement Analysis
2. UI/UX Prototyping
3. Database & API Design
4. Frontend & Backend Development
5. Testing & QA
6. Deployment & Maintenance
Admin App: http://39.105.202.74:8092
Mobile App: http://39.105.202.74:8093

## Prototype
- **Mobile App Prototype:** [View Here](https://modao.cc/proto/yaPxwdkwrvtlaepAbqZzO/sharing?view_mode=device&screen=rbpTgNkz0plpyCNJi&canvasId=rcTgNntk14ENgkLr)
- **Admin Dashboard Prototype:** [View Here](https://modao.cc/proto/jyri5tlrvvh6dn3SWyLBQ/sharing?view_mode=device&screen=rbpTgTi9axnREyQVW&canvasId=rcTgTi9ay8uTGyt0)

## Contribution
Contributions are welcome! Feel free to fork the repository and submit a pull request.

## License
This project is licensed under the **MIT License**.

---
Built with ❤️ by Ryan

