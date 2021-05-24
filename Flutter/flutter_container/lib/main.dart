import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Home(),
  ));
}

class Home extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('my first app'),
        centerTitle: true,
        backgroundColor: Colors.red[600],
      ),
      body: Row(
        children: <Widget>[
          Expanded(
            child: Image.asset('asset/dannyFace.jpg'),
            flex: 4,
          ),
          Expanded(
            flex: 3,
            child: Container(
              color: Colors.cyan,
              padding: EdgeInsets.all(30.0),
              child: Text('1'),
            ),
          ),
          Expanded(
            flex: 2,
            child: Container(
              color: Colors.amber,
              padding: EdgeInsets.all(30.0),
              child: Text('2'),
            ),
          ),
          Expanded(
            flex: 1,
            child: Container(
              color: Colors.pink,
              padding: EdgeInsets.all(30.0),
              child: Text('3'),
            ),
          )
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {},
        child: Text('Button'),
        backgroundColor: Colors.red[600],
      ),
    );
  }
}
