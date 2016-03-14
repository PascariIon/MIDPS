//---------------------------------------------------------------------------

#include <vcl.h>
#pragma hdrstop

#include "Unit1.h"
//---------------------------------------------------------------------------
#pragma package(smart_init)
#pragma resource "*.dfm"
TForm1 *Form1;

int n;
//---------------------------------------------------------------------------
__fastcall TForm1::TForm1(TComponent* Owner)
        : TForm(Owner)
{
}
//---------------------------------------------------------------------------

void __fastcall TForm1::UPClick(TObject *Sender)
{
        n += 1;
        text->Text = IntToStr(n);
}
//---------------------------------------------------------------------------
void __fastcall TForm1::DOWNClick(TObject *Sender)
{
        n -= 1;
        text->Text = IntToStr(n);
}
//---------------------------------------------------------------------------
void __fastcall TForm1::EXITClick(TObject *Sender)
{
        Form1->Close();        
}
//---------------------------------------------------------------------------



//---------------------------------------------------------------------------

void __fastcall TForm1::RESETClick(TObject *Sender)
{
        n = 0;
        text->Text = IntToStr(n);
}


//---------------------------------------------------------------------------


void __fastcall TForm1::textKeyDown(TObject *Sender, WORD &Key,
      TShiftState Shift)
{
        switch( Key )
	{
	case VK_DOWN:
                n = n - 1;
                text->Text = IntToStr(n);
		break;
	case VK_DELETE:
		ShowMessage("Can't Delete This");
		break;
	}
}
//---------------------------------------------------------------------------

void __fastcall TForm1::textKeyUp(TObject *Sender, WORD &Key,
      TShiftState Shift)
{
        switch( Key )
	{
	case VK_UP:
                n = n + 1;
                text->Text = IntToStr(n);
		break;
	case VK_DELETE:
		ShowMessage("Can't Delete This");
		break;
	}
}
//---------------------------------------------------------------------------

