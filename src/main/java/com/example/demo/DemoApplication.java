package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(DemoApplication.class, args);


		String jsonString = """
  [
  {
    "user": {
      "id": 1,
      "name": { "first": "Alice", "last": "Smith" },
      "contact": {
        "email": "alice@example.com",
        "phones": [
          { "type": "mobile", "number": "111-222-3333" }
        ]
      },
      "address": {
        "billing": {
          "street": "1 Apple St",
          "city": "Wonderland",
          "postalCode": "12345",
          "country": { "name": "Wonderlandia", "code": "WL" }
        },
        "shipping": { "street": "", "city": "", "postalCode": "", "country": { "name": "", "code": "" } }
      },
      "preferences": {
        "language": "en",
        "currency": "USD",
        "notifications": { "email": true, "sms": false, "push": { "enabled": true, "sound": "ding" } }
      },
      "metadata": {
        "createdAt": "2024-01-01T10:00:00Z",
        "lastLogin": "2024-04-01T09:30:00Z",
        "accountType": "premium"
      }
    }
  },
  {
    "user": {
      "id": 2,
      "name": { "first": "Bob", "last": "Johnson" },
      "contact": {
        "email": "bob@example.com",
        "phones": []
      },
      "address": {
        "billing": {
          "street": "22 Oak Lane",
          "city": "Atlantis",
          "postalCode": "67890",
          "country": { "name": "Oceanic", "code": "OC" }
        },
        "shipping": { "street": "", "city": "", "postalCode": "", "country": { "name": "", "code": "" } }
      },
      "preferences": {
        "language": "fr",
        "currency": "EUR",
        "notifications": { "email": true, "sms": false, "push": { "enabled": true, "sound": "bubble" } }
      },
      "metadata": {
        "createdAt": "2023-11-01T09:00:00Z",
        "lastLogin": "2024-04-07T13:00:00Z",
        "accountType": "standard"
      }
    }
  },
  {
    "user": {
      "id": 3,
      "name": { "first": "Charlie", "last": "Brown" },
      "contact": {
        "email": "charlie@example.com",
        "phones": [
          { "type": "home", "number": "999-888-7777" }
        ]
      },
      "address": {
        "billing": {
          "street": "55 Peanuts Blvd",
          "city": "Springfield",
          "postalCode": "22222",
          "country": { "name": "USA", "code": "US" }
        },
        "shipping": { "street": "", "city": "", "postalCode": "", "country": { "name": "", "code": "" } }
      },
      "preferences": {
        "language": "es",
        "currency": "USD",
        "notifications": { "email": true, "sms": true, "push": { "enabled": false, "sound": "" } }
      },
      "metadata": {
        "createdAt": "2022-07-01T08:00:00Z",
        "lastLogin": "2024-03-28T14:15:00Z",
        "accountType": "free"
      }
    }
  },
  {
    "user": {
      "id": 4,
      "name": { "first": "Diana", "last": "Prince" },
      "contact": {
        "email": "diana@example.com",
        "phones": []
      },
      "address": {
        "billing": {
          "street": "Themyscira Palace",
          "city": "Themyscira",
          "postalCode": "00001",
          "country": { "name": "Amazonia", "code": "AM" }
        },
        "shipping": { "street": "", "city": "", "postalCode": "", "country": { "name": "", "code": "" } }
      },
      "preferences": {
        "language": "gr",
        "currency": "Drachma",
        "notifications": { "email": true, "sms": true, "push": { "enabled": true, "sound": "amazon-drum" } }
      },
      "metadata": {
        "createdAt": "2021-05-10T12:00:00Z",
        "lastLogin": "2024-04-05T10:10:10Z",
        "accountType": "admin"
      }
    }
  },
  {
    "user": {
      "id": 5,
      "name": { "first": "Ethan", "last": "Hunt" },
      "contact": {
        "email": "ethan@example.com",
        "phones": [{ "type": "mobile", "number": "007-007-0007" }]
      },
      "address": {
        "billing": {
          "street": "Mission HQ",
          "city": "Berlin",
          "postalCode": "10115",
          "country": { "name": "Germany", "code": "DE" }
        },
        "shipping": { "street": "", "city": "", "postalCode": "", "country": { "name": "", "code": "" } }
      },
      "preferences": {
        "language": "de",
        "currency": "EUR",
        "notifications": { "email": true, "sms": false, "push": { "enabled": true, "sound": "beep" } }
      },
      "metadata": {
        "createdAt": "2022-12-31T23:59:59Z",
        "lastLogin": "2024-04-01T07:00:00Z",
        "accountType": "secret"
      }
    }
  },
  {
    "user": {
      "id": 6,
      "name": { "first": "Fiona", "last": "Gallagher" },
      "contact": {
        "email": "fiona@example.com",
        "phones": []
      },
      "address": {
        "billing": {
          "street": "South Side",
          "city": "Chicago",
          "postalCode": "60608",
          "country": { "name": "USA", "code": "US" }
        },
        "shipping": { "street": "", "city": "", "postalCode": "", "country": { "name": "", "code": "" } }
      },
      "preferences": {
        "language": "en",
        "currency": "USD",
        "notifications": { "email": false, "sms": false, "push": { "enabled": false, "sound": "" } }
      },
      "metadata": {
        "createdAt": "2020-03-15T15:00:00Z",
        "lastLogin": "2024-04-06T16:45:00Z",
        "accountType": "guest"
      }
    }
  }
]

				    """;

	ObjectMapper mapper = new ObjectMapper();
	SimpleModule module = new SimpleModule();
	module.addDeserializer(model.class, new deserial());
	mapper.registerModule(module);

	List<model> users = mapper.readValue(jsonString, new TypeReference<List<model>>() {});
	users.forEach(System.out::println);
	}

}
