import 'package:http/http.dart';
import 'dart:convert';

class WorldTime {
  String location; // location name for the UI
  String time; // the time ibn that location
  String flag; // url to an asset flag icon
  String url; // location url for api endpoint

  WorldTime({this.location, this.flag, this.url});

  Future<void> getTime() async {
    // make the request
    Uri URL = Uri.parse('https://www.worldtimeapi.org/api/timezone/Asia/Tokyo');
    // Response response =
    //     await get(new Uri.https("worldtimeapi.org", '/api/timezone/$url'));
    Response response =
        await get(Uri.parse('https://www.worldtimeapi.org/api/timezone/$url'));
    Map data = jsonDecode(response.body);
    // print(data);

    // get properties from the data
    String dateTime = data['datetime'];
    String offset = data['utc_offset'].substring(1, 3);

    // print(dateTime);
    // print(offset);

    // create DateTime obj
    DateTime now = DateTime.parse(dateTime);
    now = now.add(Duration(hours: int.parse(offset)));
    // print('now: $now');

    // set the time property
    time = now.toString();
  }
}
