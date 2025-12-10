# Simple Flight API Service

## Опис

**Simple Flight API Service** — простий REST API сервіс на базі Spring Boot для управління інформацією про авіарейси. Користувач може отримувати список доступних рейсів, додавати нові, переглядати деталі рейсу за його ID та видаляти рейси.

## Функціонал

- **GET /flights** — отримати список усіх рейсів
- **GET /flights/{id}** — отримати деталі певного рейсу
- **POST /flights** — створити новий рейс
- **DELETE /flights/{id}** — видалити рейс

Рейси представлені моделлю `Flight`, яка містить:
- `id`: Унікальний ідентифікатор
- `departure`: Місто відправлення
- `arrival`: Місто прибуття
- `departureDateTime`: Дата та час відправлення
- `arrivalDateTime`: Дата та час прибуття
- `price`: Вартість квитка
- `flight_number`: Номер рейсу
- `creation_date`: Дата створення запису

## Стек технологій

- **Java 17+**
- **Spring Boot**
- REST API

## Швидкий старт (Локально)

1. Клонуйте репозиторій:
    ```bash
    git clone https://github.com/WubbaLubbaDubDubDev/simple-flight-api-service.git
    ```
2. Перейдіть у папку:
    ```bash
    cd simple-flight-api-service
    ```
3. Запустіть застосунок:
    ```bash
    ./gradlew bootRun
    ```

## Запуск за допомогою Docker Compose

Для запуску у ізольованому контейнері виконайте наступні кроки:

1. **Зберіть JAR-файл застосунку:**
   *(Цей крок необхідний, оскільки Dockerfile використовує локально зібраний файл)*
    ```bash
    ./gradlew clean build -x test
    ```

2. **Запустіть контейнер:**
    ```bash
    docker-compose up --build
    ```
    *Щоб запустити у фоновому режимі, додайте прапорець `-d`: `docker-compose up -d`*

3. **Зупинка застосунку:**
    ```bash
    docker-compose down
    ```

Застосунок буде доступний за адресою: `http://localhost:8080`

## Приклади запитів

### Отримати всі рейси

```
GET http://localhost:8080/flights
```

### Додати новий рейс

```
POST http://localhost:8080/flights
Content-Type: application/json

{
    "id": 3,
    "departure": "Dnipro",
    "arrival": "Kharkiv",
    "departureDateTime": "2025-12-10T14:30:00",
    "arrivalDateTime": "2025-12-10T16:00:00",
    "price": 2000.0,
    "flight_number": "DN500"
}
```

### Видалити рейс

```
DELETE http://localhost:8080/flights/3
```

## Ліцензія

MIT

---

**Автор:** [WubbaLubbaDubDubDev](https://github.com/WubbaLubbaDubDubDev)
