C     A program which counts from 1 to 10.
1337  FORMAT(I4,I8,I8)
1338  FORMAT(3X,"I",2X,"Square",4X,"Cube")
      WRITE(*,1338)
      DO 10 I=1,10
      WRITE(*,1337) I, I**2, I**3
10    CONTINUE
      END