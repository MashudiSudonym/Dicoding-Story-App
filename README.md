* add base url for api on local.properties :
  ```baseURL = "https://story-api.dicoding.dev/v1/"```

* create file
  ```storyapp/app/src/release/res/values/google_maps_api.xml```
  and ```storyapp/app/src/debug/res/values/google_maps_api.xml```

* write this code into those file

  ```<resources> <string name="google_maps_key" templateMergeStrategy="preserve" translatable="false">GET_KEY_FROM_GOOGLE_CONSOLE</string> </resources>```