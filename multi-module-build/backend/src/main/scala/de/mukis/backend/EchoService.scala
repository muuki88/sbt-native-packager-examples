package de.mukis.backend

import de.mukis.api.EchoAPI._

class EchoService {

    def echo(msg: String): Echo = Echo(s"echo: $msg")
    
}
