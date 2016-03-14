object Form2: TForm2
  Left = 258
  Top = 226
  BorderStyle = bsSingle
  Caption = 'Barograf [MIDPS]'
  ClientHeight = 399
  ClientWidth = 630
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object PaintBox1: TPaintBox
    Left = 344
    Top = 120
    Width = 242
    Height = 242
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -11
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    OnPaint = PaintBox1Paint
  end
  object Label1: TLabel
    Left = 392
    Top = 32
    Width = 147
    Height = 14
    Caption = 'Current date and time'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -11
    Font.Name = 'Monaco'
    Font.Style = []
    ParentFont = False
  end
  object Label2: TLabel
    Left = 32
    Top = 16
    Width = 252
    Height = 26
    Caption = 'Graphic resources '
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -21
    Font.Name = 'Monaco'
    Font.Style = [fsBold]
    ParentFont = False
  end
  object Label3: TLabel
    Left = 136
    Top = 48
    Width = 28
    Height = 26
    Caption = 'of'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -21
    Font.Name = 'Monaco'
    Font.Style = [fsBold]
    ParentFont = False
  end
  object Label4: TLabel
    Left = 80
    Top = 72
    Width = 154
    Height = 26
    Caption = 'C++Builder '
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -21
    Font.Name = 'Monaco'
    Font.Style = [fsBold]
    ParentFont = False
  end
  object Panel2: TPanel
    Left = 240
    Top = 120
    Width = 81
    Height = 240
    Color = clActiveBorder
    TabOrder = 1
  end
  object Button1: TButton
    Left = 56
    Top = 192
    Width = 105
    Height = 33
    Caption = 'Start'
    TabOrder = 2
    OnClick = Button1Click
  end
  object Button2: TButton
    Left = 56
    Top = 248
    Width = 105
    Height = 33
    Caption = 'Stop'
    TabOrder = 3
    OnClick = Button2Click
  end
  object Button3: TButton
    Left = 56
    Top = 304
    Width = 105
    Height = 33
    Caption = 'Exit'
    TabOrder = 4
    OnClick = Button3Click
  end
  object Edit1: TEdit
    Left = 344
    Top = 56
    Width = 241
    Height = 33
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -20
    Font.Name = 'Monaco'
    Font.Style = []
    ParentFont = False
    TabOrder = 5
    Text = '00-00-0000 00:00:00'
  end
  object Panel1: TPanel
    Left = 240
    Top = 120
    Width = 81
    Height = 153
    Caption = 'Panel1'
    Color = clBackground
    TabOrder = 0
  end
  object Timer1: TTimer
    OnTimer = Timer1Timer
    Left = 56
    Top = 120
  end
  object Timer2: TTimer
    Interval = 100
    OnTimer = Timer2Timer
    Left = 128
    Top = 120
  end
end
