## Overview
An app, that fetches data from http://mobcategories.s3-website-eu-west-1.amazonaws.com/ and shows list with products categorized per category.
Clicking on item opens product details, that contains name and description of product, bigger image and price.

## Screens
<div align = "center">
    <img src = "https://user-images.githubusercontent.com/26003155/106025696-4b1fcb80-60c9-11eb-9421-56512654a547.png" width="330">
    <img src = "https://user-images.githubusercontent.com/26003155/106025909-83bfa500-60c9-11eb-987f-81b37532b296.png" width="330">
</div>
    
## Chosen architecture
* clean = for easy support/changes
* MVVM pattern for UI = for better support, handling activity state

## Chosen libraries
* RXJava for asynchronous calls = most stable
* Dagger for DI = compile-time checking
* Retrofit for network = simplest
* Glide for pictures loading = simplest

## Not implemented (time lack)
Cache, actual category id with categoryId in product checking, proper navigation and logging 