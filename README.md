# letsgetchecked-qae-tech-challenge

## Getting Started

### Languages and frameworks
```
Core Language: Java
Frameworks:
    - Selenium
    - Junit
```

### Project Structure 

```
- "MapsPageTests.java" : File with the definition of the test cases

- "MapsPageElements.java" : File with the definition of methods that are responsible for returning the elements selectors

- "MapsPageLocators.java" : File with the definition of all the elements locators

- "BrowserSetupSteps.java" : Java file with the definition of methods for the initialization/management of the browser instance

NOTE: Project dependecies added to the "pom" XML file
```

## Objectives

### Challenge task list

- [x] Go to https://www.google.com/maps
- [x] Enter Dublin in the search box
- [x] Search
- [x] Verify left panel has "Dublin" as a headline text
- [x] Click Directions icon
- [x] Verify destination field is "Dublin"

### Test cases definition (Challenge task list)

```
@Test
(searchForLocation)

    - Verify if the search box is displayed on the page
    - Click and write location on search input field
    - Click on the search button
    - Verify if the left panel is displayed on the page
    - Verify if the left panel headline contains the correct location ("Dublin")
    - Verify if iconic section contains the correct place ("Guinness Storehouse")
```

```
@Test
(getDirectionsForLocation)

    - Verify if the search box is displayed on the page
    - Click and write location on search input field
    - Click on the search button
    - Verify that destination search input contains the correct location ("Dublin")
    - Click on the car button
    - Click and write the starting point on the search input
    - Click on the directions search button
    - Verify if the trip section is displayed
    - Click on the trip options button and select "km" radio button
    - Verify if the trip fields (time and distance) are displayed
```

## Instructions

* On the file inside specs folder ("MapsPageTest"), change the "BROWSER" to the driver to be used in the automation (Chrome, Safari or Firefox).

```
Browsers supported:
    - Chrome
    - Edge
    - Safari
```

* Run the file to execute the test cases.