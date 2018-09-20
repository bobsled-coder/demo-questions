# Description #
Build a Service that is horizontally scalable leveraging Spring Boot, Liquibase, JPA and MySQL

# Scaling #
This service should be able to handle many views.  To make this scale the JPA cache will have to be disabled so that request coming in update from the database.  Otherwise.  This will have to be placed behind a load balancer and it should just work.  Users are stored with each View, so the same user could make multiple requests to different services, with no need for coordination.  UUID's are generated on view insert to allow for the scaling of the service, and the independence from other services. 

# API #
## Question ##
Used for manipulating the questions in the database.  Should be used by a configuration screen.  Should not be used to retrieve questions for embedding in your quiz page

### POST /question ###

```javascript
 {
    "question": "xxxx",
    "predictions": [{
            "questionPredictionId": 40,
            "questionId": 4,
            "columnName": "Age/Gender",
            "rowName": "<18",
            "columnOrder": 1,
            "rowOrder": 1,
        }]
}
```

### GET /question/\<id\> ###
### PUT /question/\<id\> ###
### DELETE /question/\<id\> ###

## EmbedView ##
This REST API should be used for interacting with the questions.  When you call embedView with the site unique identifier the unique identifier of the embeded JavaScript and the User that is interacting with the widget.  

### POST /embedview ###
When POST is called a view request is created in the database with a unique viewID.  This Randomly selects a question for the Site for the given userUUiD and returns it.  If the the user has answered all the questions it randomly selects from all site questions.
#### Request #### 
```javascript
 {
	"siteUUID": "ba0011e8-58ce-59ad-a004-a44cc8426580",
	"embedUUID": "570e6637-2a3a-4670-a70a-6cee956ca64b",
	"userUUID": "ca0011e8-58ce-59ad-a004-a44cc8426581"
}
```

####  Response #### 
This is the description of the message.  The unique View UUID exists to identify the instance of this question.  If there are headers, they are populated in the headers array.  Each Row consists of label and the number of predictions.  If there are multiple columns there will be multiple prediction options.  This JSON indicates the maximum and minimum number of selections to submit the question.
```javascript
{
    "viewUUID": "e2ff7292-530b-4764-a3a1-17c54762270c",
    "headers": [],
    "rows": [
        {
            "label": "Falcons",
            "predictions": [
                10
            ]
        },
        {
            "label": "Patriots",
            "predictions": [
                11
            ]
        }
    ],
    "maxResponses": 1,
    "minResponses": 1
}
```
### POST /embedview/\<embedviewuuid\> ###

#### Request #### 
```javascript
{
    "viewUUID": "e2ff7292-530b-4764-a3a1-17c54762270c",
    "answers": [10]
}
```

####  Response #### 

```javascript
{
    "viewUUID": "e2ff7292-530b-4764-a3a1-17c54762270c",
    "answer": [
        {
            "columnName": null,
            "rowName": "Patriots"
        }
    ]
}
```
