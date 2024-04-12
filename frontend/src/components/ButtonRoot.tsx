import { ComponentProps } from 'react';

type ButtonRootProps = ComponentProps<'button'>;
type ButtonTextProps = ComponentProps<'span'>;

export const ButtonRoot: React.FC<ButtonRootProps> = ({
  children,
  className,
  ...props
}) => {
  return (
    <button
      {...props}
      className={`group bg-white max-w-full py-3 rounded-md hover:bg-gray-400 hover:text-white md:max-w-40 ${className}`}
    >
      {children}
    </button>
  );
};

export const ButtonText: React.FC<ButtonTextProps> = ({
  children,
  className,
  ...props
}) => {
  return (
    <span {...props} className={`font-semibold ${className}`}>
      {children}
    </span>
  );
};
