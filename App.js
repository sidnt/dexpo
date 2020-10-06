// import { StatusBar } from 'expo-status-bar';
// import React from 'react';
// import { StyleSheet, Text, View } from 'react-native';

/**
 * so looks like this is the place
 * the entrypoint to the app's domain logic
 * after going through all the infrastructure-bootstrapping jobs
 * .
 * whereas the default expo template uses the ESM export style
 * the default slinky template uses the module.exports style
 * .
 * the expo machinery might actually be importing this top level
 * export from the App.js and putting it into action.
 * .
 * this is where the handoff happens.
 * the slinky expo-scala-template does this
 * module.exports = require("./target/scala-2.13/app-fastopt.js").app;
 * through this incantation here, the `@JSExportTopLevel("app")` in the Main object
 * is basically handed-off to expo
 * .
 * using def main(args: Array[String]): Unit in sjs with scalaJSUseMainModuleInitializer := true
 * automatically calls the main method at the end of the script exported by ..OptJs task
 * slinky's build.sbt doesn't use a main module initializer
 * neither does Main object extend any sort of zio.App scala.App or def main(...)
 * .
 * so looks like the def main(...) counterpart invocation is in expo-land.
 * we are just handing off a component, it is being loaded in expo-land.
 * .
 * must there be a specific requirement on what's exported from here though
 */

module.exports = require("./target/scala-2.13/dexpo-fastopt.js").app;

// export default function App() {
//   return (
//     <View style={styles.container}>
//       <Text>Open up App.js to start working on your app!</Text>
//       <StatusBar style="auto" />
//     </View>
//   );
// }

// const styles = StyleSheet.create({
//   container: {
//     flex: 1,
//     backgroundColor: '#fff',
//     alignItems: 'center',
//     justifyContent: 'center',
//   },
// });
