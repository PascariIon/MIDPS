//---------------------------------------------------------------------------

#ifndef Unit1H
#define Unit1H
//---------------------------------------------------------------------------
#include <Classes.hpp>
#include <Controls.hpp>
#include <StdCtrls.hpp>
#include <Forms.hpp>
//---------------------------------------------------------------------------
class TForm1 : public TForm
{
__published:	// IDE-managed Components
        TButton *DOWN;
        TButton *UP;
        TEdit *text;
        TButton *EXIT;
        TLabel *Label1;
        TButton *RESET;
        void __fastcall UPClick(TObject *Sender);
        void __fastcall DOWNClick(TObject *Sender);
        void __fastcall EXITClick(TObject *Sender);
        void __fastcall RESETClick(TObject *Sender);
        void __fastcall textKeyDown(TObject *Sender, WORD &Key,
          TShiftState Shift);
        void __fastcall textKeyUp(TObject *Sender, WORD &Key,
          TShiftState Shift);

private:	// User declarations
public:		// User declarations
        __fastcall TForm1(TComponent* Owner);
};
//---------------------------------------------------------------------------
extern PACKAGE TForm1 *Form1;
//---------------------------------------------------------------------------
#endif
