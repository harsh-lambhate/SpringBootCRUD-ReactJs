# <h1 align="center">About React </h1>

## Commands 
* View Readme.md file in VS Code `Ctrl+Shift+V`     
* Create react project  `npx create-react-app projectName`   
* Run react `npm start`   
* Install Axios `npm install axios --save`  
* Install React bootstrap `npm install react-bootstrap bootstrap`             
* Install bootstrap `npm install bootstrap --save`    
* Install router v5 `npm install react-router-dom@5.2.0`                   
* Install router v6 `npm install react-router-dom@6`                       
* Uninstall router `npm uninstall react-router-dom`
* Install React Icons `npm install react-icons`


## Definations 

### State 
The state is a built-in React object that is used to contain data or information about the component. It is mutable and cannot be access by child component

### React Hooks 
Hooks introduce in react version 16.8. It allows you to use state and other features without writing a class.It use useState and useEffect
* `useState()` is used to manage state within a component for setting and retrieving state 
* `useEffect()` is used to perform side effects in a component, such as updating the document title, fetching data, or subscribing to events

### Component
React Component are two types :
* Functional Component/Stateless Component  : It contain only render methods and don't have their own state.
* Class Component : You can pass data from one to another component


### Constructor
The constructor is a method used to initialize an object state in class.It automatically called during object creation. It is use for binding event handler methods that occurs in your component.

```
constructor(props){
     super(props);
}
```

### Props
Props stands for properties. They are read-only components. It is an object which store the value of attribute of a tag and work similar to the HTML attribute. Props are immutable so we cannot modify this props from inside the component.

### React Life cycle hook
Initial Phase -> Mounting Phase -> Updating Phase -> Unmounting Phase

* Initial Phase 

`getDefaultProps()` : 
It is used to specify th default value if this state .It is invoked before the creation of component.

* Mounting Phase 

`componentWillMount()` :
This is invoked immediately before a component gets rendered into th DOm. In this case when you call setState() inside this method.

`ComponentDidMount()` :
This is invoked immediately after component gets rendered and placed on the DOM. You can do any DOM querying operations.

`render()` :
This method is defined in each and every component. It is responsible returning a single root HTML node element.

* Updating Phase

`ComponentWillRecieveProps()` :
Ts is invoked when a component receives new props.If you want to update the state in response to prop changes, you should compare this props and nextprops to perform state transition by using this setState()

`ShouldComponentUpdate()` :
It is invoked when a component decides updating occurs

`ComponentWillUpdate()` :
It is invoked just before the component updating occurs Here you can't change the component state by invoking this setState() method.

`ComponentDidUpdate()` :
It is invoked immediately after the component updating occurs In this method you can put any course inside this

* UnmountingPhase

`componentWillUnmount()` :
This method is invoked immediately before a component is destroyed permanently.It perform necessary cleanup.

### React Router
React Router mainly use for developing single page application, it use to define multiple routes in an application. React contain three deferent package of routing
* react router : It provide core routing components and funtion for the react router application
* react-router-native : It is use for mobile application
* react-router-dom : It is use for web application
#### Router v6
```
 <Router>
        <HeaderComponent />
        <div >
        <Routes >
          <Route path="/" exact element={<About />} />
          <Route path="/about"  element={<About />} />
        </Routes>
        </div>
        <FooterComponent />
      </Router>
```

**Building dynamic UIs with ease, simplicity, and efficiency.**