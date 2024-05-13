import { ComponentProps } from 'react';

type HeadingH1Props = {
  children?: React.ReactNode;
} & ComponentProps<'h1'>;

export const HeadingH1: React.FC<HeadingH1Props> = ({ children, ...props }) => {
  return (
    <>
      <h1 {...props} className='font-black text-3 text-gray-900 mb-2'>
        {children}
      </h1>
    </>
  );
};

type HeadingH2Props = {
  children?: React.ReactNode;
} & ComponentProps<'h2'>;

export const HeadingH2: React.FC<HeadingH2Props> = ({ children, ...props }) => {
  return (
    <>
      <h2 {...props} className='font-light text-sm text-gray-600 mb-2'>
        {children}
      </h2>
    </>
  );
};
