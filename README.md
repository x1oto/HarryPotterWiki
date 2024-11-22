# Application Features Overview

## Application schema on Draw.io: https://tinyurl.com/5n7c8sek


The application has been implemented with the following key functionality:

## 1. Displaying a List of All Characters

In `CharactersViewModel`, the logic for retrieving data includes checking for existing records in the local database (Room):

- If records are found in the database, they are passed to `CharactersFragment`.
- If the database is empty, an HTTP GET request is made using Retrofit to `https://hp-api.onrender.com/api/characters`.

In both cases (data from the database or the API response), the result is passed to `CharactersFragment` as `Status.Success(Characters)`.

If data retrieval fails (from both the database and the API), `Status.Error` is sent to the fragment. While waiting for a response, the status is set to `Status.Loading`.

## 2. Handling States in the Fragment

`CharactersFragment` observes changes to the `status` variable and uses Data Binding to automatically propagate updates to the layout-bound variable.

Based on the status value, the `BindingAdapter` is responsible for updating the screen state (loading, displaying data, or showing an error).

This approach ensures a clear separation of data logic in the ViewModel and reactive UI updates in the fragment, adhering to the MVVM architectural pattern.

## 3. Displaying All Spells with Detailed Information

When accessing the spells screen, the application makes an HTTP GET request to `https://hp-api.onrender.com/api/spells` using Retrofit. Unlike character data, the retrieved spells data is **not stored in the local database (Room)**.

### Workflow

- **API Request**:  
  Each time the user navigates to the spells fragment, a new request is sent to the API endpoint. This ensures the data displayed is always fresh, but it also means no offline support for this feature.

- **Data Binding**:  
  Once the API response is received, the data is passed to the fragment as `Status.Success(Spells)`. The fragment observes this status variable, and any updates are automatically propagated to the layout through **Data Binding**.

- **RecyclerView Display**:  
  The bound data is then used to populate the `RecyclerView` in the fragment’s layout. This setup leverages a `BindingAdapter` to dynamically update the list of spells in the view, making the UI reactive to changes in the data.

- **Navigation to Detailed View**:  
  Each spell in the `RecyclerView` is clickable. When clicked, it navigates the user to a detailed information page for the selected spell. Similarly, when the user clicks on a character, they are navigated to that character’s detailed page.

This flow provides seamless integration between API responses, UI updates, and navigation, maintaining a consistent and responsive user experience.

## 4. Displaying Characters by House  

`HouseFragment` lets users view characters from one of the four Hogwarts houses. Four buttons, each labeled with a house name (e.g., "Gryffindor"), trigger an HTTP GET request to: `https://hp-api.onrender.com/api/characters/house/{house}`

Upon a successful response, the data is passed to a `RecyclerView adapter`, bypassing Data Binding for better control. The adapter displays the characters specific to the selected house, ensuring dynamic API interaction and efficient data presentation.

## 5. Teaching a Random Spell to Each Character
A random spell is assigned to each character, with data persistence across sessions. Initially, characters have no spells. When a character's card is clicked, a random spell is assigned.

The spell assignment is permanent, stored in local storage, and persists even after app restarts. This feature ensures unique interaction for each character while maintaining a one-time assignment.

## 6. Ability to Swap House for a Character
Users can change a character's house multiple times, with data persistence across sessions. Initially, characters are not assigned to any house. When a house is changed, it is stored in local storage and persists across app closures and reopenings. Unlike spells, the house assignment can be modified as needed, providing flexibility while maintaining data integrity.




