# How to Run the Project

## ✅ Prerequisites
- Java 17 installed
- Maven (Maven Wrapper is already included in the project)
- Git installed

---

## 📦 Set up the Project

### Primary option (recommended)
1. Unzip the file **`api-meli.zip`** provided with the submission.
2. Navigate into the extracted folder:
```bash
cd api-meli
```

### Secondary option (via GitHub)
If you prefer to get the project directly from GitHub:
```bash
git clone https://github.com/jhoangg88/api-meli.git
cd api-meli
```

---

## ▶️ Run the Application
Using Maven Wrapper:
```bash
./mvnw spring-boot:run
```

The API will be available at:
👉 http://localhost:8080/api/v1/products

---

## 🧪 Run Tests

### 1. Unit Tests + JaCoCo
```bash
./mvnw test jacoco:report
```

### 2. Mutation Testing (PIT)
```bash
./mvnw org.pitest:pitest-maven:mutationCoverage
```

### 3. Acceptance Tests (Karate)
```bash
./mvnw test -Dtest=KarateAcceptanceTest
```

### 4. Performance Tests (JMeter)
To execute the performance tests:

1. **Start the API**  
   Make sure the application is running at `http://localhost:8080`.
    ```bash
       ./mvnw spring-boot:run
    ```
   
2. **Open JMeter**  
   Use Apache JMeter 5.6.3 installed on your machine

3. **Load the test plan**  
   In JMeter, open the file located at:
    ```bash
       src/test/jmeter/test-plan-performance.jmx
    ```

4. **Run the test plan**  
   Click the ▶️ Start button in JMeter to execute the performance tests.

---

## ⚙️ CI/CD
A **GitHub Actions pipeline** is configured in `.github/workflows/ci.yml`.  
It automatically runs on every push to the `main` branch and executes:
- Unit tests + coverage
- Karate acceptance tests
- PIT mutation testing
- JMeter performance tests
- SonarCloud analysis

---

## 📂 Notes
- All persistence is handled with local JSON files (no real database required).
- Error responses follow a consistent JSON format defined in the `GlobalExceptionHandler`.