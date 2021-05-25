import 'package:flutter/material.dart';

void main() {
  runApp(HolaMundo());
}
class HolaMundo extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Hola Mundo'),
        ),
        body:
        Center(
          child: Column(
            children: <Widget>[
              Image.asset('assets/img/retrato.png'),
              Text('Javier Pedraza Cruz',
                style: TextStyle(fontSize: 25),
              ),
              Text('Estudiante de ISC, Tecnologíco de Morelia', style:TextStyle(fontSize: 18)),
              Text('No Control 15121197', style:TextStyle(fontSize: 18)),
              Text('Conocedor de Quesadillas', style:TextStyle(fontSize: 18)),

            ],
          )
        ),
      ),
    );

    //throw UnimplementedError();
  }//Build Widget
}//class HolaMundo
