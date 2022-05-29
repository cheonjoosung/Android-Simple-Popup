# Android-Simple-Popup
This is a Custom Simple-Popup for Android.

## Sample
<img src="https://github.com/cheonjoosung/Android-Simple-Popup/blob/master/image/sample.jpeg" alt="sample" height="500" width="300">


## How To
Add below code in gradle (project)

- gradle past version

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

- gradle current version

```gradle
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        maven { url "https://jitpack.io" } // add this line
        mavenCentral()
    }

}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        maven { url "https://jitpack.io" } // add this line

    }
}
```

- Add below codes in gradle (module)

```gradle
dependencies {
    implementation 'com.github.cheonjoosung:Android-Simple-Popup:0.0.1'
}
```

## Sample Code
```kotlin
val tv = findViewById<TextView>(R.id.tv)
tv.setOnClickListener {
    val list = mutableListOf<SimplePopupValue>().apply {
        add(SimplePopupValue("menu_title_01", R.mipmap.ic_launcher))
        add(SimplePopupValue("menu_title_02", R.mipmap.ic_launcher))
        add(SimplePopupValue("menu_title_03", R.mipmap.ic_launcher))
    }

    SimplePopup(context = applicationContext, popupList = list) { _, popupValue, position ->
        when (position) {
            0 -> {
                Toast.makeText(applicationContext,
                    "Clicked $position ${popupValue.title}",
                    Toast.LENGTH_SHORT).show()
            }

            1 -> {
                Toast.makeText(applicationContext,
                    "Clicked $position ${popupValue.title}",
                    Toast.LENGTH_SHORT).show()
            }

            2 -> {
                Toast.makeText(applicationContext,
                    "Clicked $position ${popupValue.title}",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }.apply {
        isOutsideTouchable = true
        isTouchable = true
        showAsDropDown(it, 60, 10)
    }
}
```
