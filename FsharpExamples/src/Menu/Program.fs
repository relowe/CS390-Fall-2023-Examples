open System

// For more information see https://aka.ms/fsharp-console-apps
let rec menu () = 
     printfn "1.) Item 1"
     printfn "2.) Item 2"
     printfn "3.) Item 3"
     printfn ""
     printf "Choice? "
     let input = Console.ReadLine()
     match input with
       | "1" -> printfn "One selected"
       | "2" -> printfn "Two Selected"
       | "3" -> printfn "Three Selected"
       | _   -> 
         printfn "Invalid Choice, please try again."
         menu ()

menu  ()