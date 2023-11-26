C     FORTRAN is an imperative language
1     FORMAT(I4)
      I=1
10    IF (I.GT.10) GO TO 20
      WRITE(*,1) I
      I=I+1
      GO TO 10
20    END