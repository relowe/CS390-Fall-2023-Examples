C     Interactively compare two numbers
C     Formatters
3     FORMAT(I4)

C     Entry Point
      INTEGER X,Y
10    WRITE(*,1)
1     FORMAT("ENTER X")
      READ(*,3) X
      
      WRITE(*,2)
2     FORMAT("ENTER Y")
      READ(*,3) Y
      IF (X-Y) 20,30,40

20    WRITE(*,4)
4     FORMAT("X<Y")
      GO TO 10

30    WRITE(*,6)
6     FORMAT("X=Y")
      GO TO 10

40    WRITE(*,5)
5     FORMAT("X>Y")
      GOTO 10

      END