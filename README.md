
# Assignment

Backend Developer Intern Assignment for Lean Platform Technologies.

## Problem Statement
Create the backend APIs of the admin dashboard a Web app (that allows users to find and
book sessions with consultants).The admin dashboard is the key component of any web
app. So, that API should be very flexible to be integrated with any other component.
The admin dashboard approves the consultants account to verified status. It also keeps a
track of the no of consultants registered, no of clients registered and no of sessions booked.


# Application Usage
The Application runs on port 8080 by default
Application can be accessed using 
```http
http://localhost:8080
```

Database used in the application is H2-Database
- To start the database start the application and open
```http
http://localhost:8080/h2-console
 ```
  - url = jdbc:h2:mem:schemas
  - username = root
  - password = root

- Use postman to send API calls to application using the application url and api calls mentioned
- For Put and Post requests JSON data should be sent along with the API call
	- To send JSON data head to Postman application and click on Body
	- Under body select "raw" option and body type to "JSON"
	- Enter the request body in JSON format
-For example the api call to fetch all consultants 
 - choose Get Mapping
 ```http
 http://localhost:8080/api/admin/consultants
 ```

## API Reference

### Admin API calls

  #### Fetch all consultants/mentors
```http
  GET api/admin/consultants
```

| Parameter | Description |
|:----------| :------------|
|`none`     |  `none` |

#### fetch a mentor based on ID

```http
  GET api/admin/consultant-id/id_to_fetch
```

| Parameter | Description |
|:----------| :------------|
|`int`     |  `id of mentor` |

#### fetch a mentor based on Role

```http
  GET api/admin/consultant-role/role_to_fetch
```

| Parameter | Description |
|:----------| :------------|
|`string`     |  `role of mentor` |

#### fetch all mentor requests(user created a request to become mentor)

```http
  GET api/admin/consultant-requests
```

| Parameter | Description |
|:----------| :------------|
|`none`     |  `none` |

#### Approve a consultant request

```http
  GET api/admin/approve/id_of_request
```

| Parameter | Description |
|:----------| :------------|
|`int`     |  `id of mentor request` |

#### Add a consultant(Mentor) manually

```http
  POST api/admin/add-consultant
```

| Request Type | Parameter     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `POST`      | `Mentor` | `Body for Mentor` |

#### fetch all users

```http
  GET api/admin/get-users
```
| Parameter | Description |
|:----------| :------------|
|`none`     |  `none` |


#### View web statistics

```http
  GET api/admin/web-statistics
```
| Parameter | Description |
|:----------| :------------|
|`none`     |  `none` |




### Consultant API calls
  #### Update details of a mentor
  ```http
    PUT api/consultant/update-details
  ```

| Request Type | Parameter     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `PUT`      | `Mentor` | `Body of Mentor` |

### User API calls

   #### Fetch all consultants/mentors
```http
  GET api/user/consultants
```

| Parameter | Description |
|:----------| :------------|
|`none`     |  `none` |

#### fetch a mentor based on ID

```http
  GET api/user/consultant-id/id_to_fetch
```

| Parameter | Description |
|:----------| :------------|
|`int`     |  `id of mentor` |

#### fetch a mentor based on Role

```http
  GET api/user/consultant-role/role_to_fetch
```

| Parameter | Description |
|:----------| :------------|
|`string`     |  `role of mentor` |

#### For User to send request to become a Mentor
  ```http
    POST api/user/become-consultant
  ```

| Request Type | Parameter     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `POST`      | `Mentor Request` | `Body of Mentor Request` |

#### For a new user registration
  ```http
    POST api/user/register
  ```

| Request Type | Parameter     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `POST`      | `User` | `Body of User` |

#### For user to book a session
  ```http
    PUT api/user/book-session/phone_num_of_user
  ```

| Request Type | Parameter     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `PUT`      | `long int` | `Phone number of user` |


## Tables Created

- Mentor
- Mentor Request
- Statistics
- User

## Prerequisites

- Java >17 Installed in the System
- Apache Maven


## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/)
[![Resume]()](https://drive.google.com/file/d/1jO-fQcoP1icGoez3NLSaOOBUUlf7tooH/view?usp=drive_link)

# Thank you

