C     Demonstrate subroutines and arrays
      SUBROUTINE PRINT_AR(A)
      INTEGER A(10)
      DO 10 I=1,10
      WRITE(*,1)A(I)
1     FORMAT(I4)
10    CONTINUE
      RETURN
      END

      DIMENSION IAR(10)
      DO 10 I=1,10
      READ(*,1) IAR(I)
1     FORMAT(I4)
10    CONTINUE
      CALL PRINT_AR(IAR)
      END