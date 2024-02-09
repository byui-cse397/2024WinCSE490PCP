Week 1-2
```mermaid
classDiagram
      Project <|-- Requirements
      Project <|-- DevEnvironment
      Project <|-- RuntimeEnvironment
      Project : +PM()
      Project : +Customer(BroClements)
      class Requirements{
          +String Lead(Darcy Merilan)
          +String TeamMember(Andrew Swayze)
          +String TeamMember(Anita Woodford)
          +String TeamMember(Allan Marina)
          +String TeamMember(Nolan Jeppson)
          +String TeamMember(Kristina Hayes)  
      }
      class DevEnvironment{
          +String Lead(Joshua Bee)
          +String TeamMember(Angela Slinker)
          +String TeamMember(Conner Wadsworth)
          +String TeamMember(George Krenk)
          +String TeamMember(Claudio Parra)
      }
      class RuntimeEnvironment{
          +String Lead()
          +String TeamMember(Jessica Vargas)
          +String TeamMember(Brian Anderson)
          +String TeamMember(Kjellden Knutzen)
          +String TeamMember(Nazanal Laughlin)
          +String TeamMember (Bryan Welton)
      }
```
Rest of the Semester
```mermaid
classDiagram
      Project <|-- FrontEnd
      Project <|-- BackEnd
      Project <|-- Database
      Project : +PM()
      Project : +Customer(BroClements)
      class FrontEnd{
          +String Lead()
          +String TeamMember(Andrew Swayze)
          +String TeamMember(Angela Slinker)
          +String TeamMember(Darcy Merilan)
          +String TeamMember(Conner Wadsworth)
          +String TeamMember(Bryan Welton)
      }
      class BackEnd{
          +String Lead()
          +String TeamMember(Jessica Vargas)
          +String TeamMember(George Krenk)
          +String TeamMember(Anita Woodford)
          +String TeamMember(Allan Marina)
          +String TeamMember(Nazanal Laughlin)
          +String TeamMember(Kristina Hayes)
          +String TeamMember(Brian Anderson)
            
      }
      class Database{
          +String Lead(Joshua Bee)
          +String TeamMember(Brian Anderson)
          +String TeamMember(Kjellden Knutzen)
          +String TeamMember(Nolan Jeppson)
          +String TeamMember(Claudio Parra)
      }
```
