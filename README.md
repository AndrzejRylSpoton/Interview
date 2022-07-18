# Interview task
This is an interview task. This app shows a simple screen displaying order info
along with items that are in this order. 
App should follow Clean Code principles and MVVM architecture pattern. However there are some
'shortcuts' in the code that we would like a candidate to spot. 
Your task is to locate the places in code which need refactoring and be able to explain
why this refactor is needed and what would be the benefits of such refactor.

## Functionalities of the app (this cannot change during refactor)
* display current order if it has been created before today
* user has to be able to see order's name, total price (sum of all items prices) and items count
* if total price is over $200, total should be marked in red
* user has to be able to see a list of all items (their name and price)
* if price of a single item is over $100, it should be marked in red