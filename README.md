# CurrencyConverterApp

Hello,

For my advanced Java class in college, I was given the task to use Android Studio to create an Android app that converts money from USD to CAD, YEN, and EUR. It also had to allow the user to enter an amount in one of these three currencies to convert it to USD. The conversion rates used here were set to:
- 1 USD = 1.26 CAD
- 1 USD = 109.94 YEN
- 1 USD = 0.85 EUR

We were given very few additional guidelines: 
- This app required two activities (pages): one where you select the target currency and one where the conversion happens.
- The main activity required radio buttons to choose the target currency and a button to go to the next page.
- The second activity required there to be fields where the user can enter USD and the target currency amounts for conversion. It also required a button to return to the first page.

How I tackled this project:
- I wanted the UI to be at least decent looking. As such, I added images to both activities and a toolbar at the top.
- The toolbar has the return button to naviage back to the main page from the conversion page.
- The rest of the main page is according to the instructions as there was not much to be done in terms of customizing there.
- The second page I had a bit more freedom with, so I chose to:
  - Use listeners for the fields to automatically update when there is user input.
  - Make sure that the amounts were formatted to only two decimal digits.
  - Ensure that the proper target currency text was displayed on the screen.

Here is my takeaway from this project:

Positive:

- There was a lot of learning about Android app development, something I had only tackled using a different IDE (Visual Studio) and language (Xamarin and C#) before.
- I have learned how to work with XML files in order for my GUI elements to properly display.
- I was able to research the bugs I was having and ensure that the issues were resolved without assistance from others, gaining confidence in my own resolution skills.

Negative:

- Had I had more time, I would have liked to tinker more with the app, making it look a lot nicer and testing it out on more than one virtual device.
- If I had complete freedom over the layout, I would have preferred using a dropdown menu for the target currency and would have also preferred everything to be in a single page, though I understand that the purpose was to have us make use of intents.
- I would have also liked for the conversion rates to be updated based on market data, though this would have required some sort of data connection and would have required more time on my end as well. 

This all being said, I'm pretty happy with the finished product!
